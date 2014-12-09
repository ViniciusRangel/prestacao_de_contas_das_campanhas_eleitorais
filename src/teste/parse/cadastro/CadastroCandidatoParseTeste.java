package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.campanha.CadastroCandidatoParse;
import teste.Template;

public class CadastroCandidatoParseTeste extends Template {

	private CadastroCandidatoParse cadastro;
	private CandidatoDAO candidatoDAO;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	@Override
	public void beforeTest() throws Exception {
		
		this.cadastro = new CadastroCandidatoParse(this.tipoArquivo, this.ano);	
		this.candidatoDAO = new CandidatoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRetornarUmCandidatoCadastrado() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[10] = "CANDIDATO TESTE";
		campo[26] = "55325424149";
		cadastro.executarLinhaDoArquivo(campo);
		cadastro.cadastrarInstancias();
		
		Candidato candidato = this.candidatoDAO.getCandidatoPeloTitulo("55325424149");
		assertEquals(candidato.getTituloEleitoral(), "55325424149");
	}

}
