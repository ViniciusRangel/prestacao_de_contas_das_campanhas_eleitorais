package controle.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Partido;
import controle.CampanhaControle;
import controle.PartidoControle;

public class VisualizarCandidatosPartido implements Logica {

	private CampanhaControle campanhaControle;
	private ArrayList<Campanha> listaCampanhas;
	private PartidoControle partidoControle;
	private Partido partido;

	private String sigla;
	private String ano;

	private HttpServletRequest req;

	private int inicio;
	private int qtdPorPagina;
	private boolean verTodos;
	private int atual;

	private int indice;
	private int qtdDePP;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.req = req;

		recebeParametros();
		estabeleceParametros();
		preparaEnvioDeParametros();

		return "/visualizar_candidato_partido.jsp";
	}

	private void recebeParametros() {
		this.sigla = req.getParameter("sigla");
		this.ano =  req.getParameter("ano");

		this.inicio = Integer.parseInt(req.getParameter("inicio"));
		this.qtdPorPagina = Integer.parseInt(req.getParameter("qtdPorPagina"));
		this.verTodos = Boolean.parseBoolean(req.getParameter("verTodos"));
	}

	private void estabeleceParametros() throws SQLException {
		this.campanhaControle = new CampanhaControle();
		this.partidoControle = new PartidoControle();

		this.partido = this.partidoControle.getPelaSigla(this.sigla);

		this.listaCampanhas = new ArrayList<>();

		this.listaCampanhas = this.campanhaControle
				.getListaCampanhasPorSiglaPartidoEAno(this.sigla,this.ano);

		this.indice = geraIndiceDaLista(this.listaCampanhas,this.qtdPorPagina);
		this.qtdDePP = geraIndiceDePaginacao(this.listaCampanhas);
		
		this.atual = (int) Math.round((float) this.inicio / (float) this.qtdPorPagina)+1;
	}

	private void preparaEnvioDeParametros() {
		this.req.setAttribute("ano", this.ano);
		this.req.setAttribute("listaCampanhas", this.listaCampanhas);
		this.req.setAttribute("partido", this.partido);

		this.req.setAttribute("sigla", this.sigla);

		this.req.setAttribute("inicio", this.inicio);
		if(this.verTodos)
			this.qtdPorPagina = this.listaCampanhas.size();

		this.req.setAttribute("qtdPorPagina", this.qtdPorPagina);
		this.req.setAttribute("indice", this.indice);
		this.req.setAttribute("qtdDePP", this.qtdDePP);
		
		this.req.setAttribute("atual", this.atual);
	}

	private int geraIndiceDaLista(List<Campanha> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}

	private int geraIndiceDePaginacao(List<Campanha> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
