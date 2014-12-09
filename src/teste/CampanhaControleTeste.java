package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.beans.Resultado;
import modelo.dao.CampanhaDAO;
import modelo.dao.CandidatoDAO;

import org.junit.Assert;
import org.junit.Test;

import controle.CampanhaControle;

public class CampanhaControleTeste extends Template {
	
	private CampanhaDAO campanhaDAO;
	private CandidatoDAO candidatoDAO;
	private CampanhaControle campanhaControle;
	private Candidato candidato;
	private Partido partido1;
	private Campanha campanha1;
	private Resultado resultado1;
	private Cargo cargo1;
	private Partido partido2;
	private Campanha campanha2;
	private Resultado resultado2;
	private Cargo cargo2;

	@Override
	public void beforeTest() throws Exception {
		
		this.campanhaDAO = new CampanhaDAO();
		this.candidatoDAO = new CandidatoDAO();
		this.campanhaControle = new CampanhaControle();
		this.campanha1 = new Campanha();
		this.partido1 = new Partido();
		this.candidato = new Candidato();
		this.resultado1 = new Resultado();
		this.cargo1 = new Cargo();
		this.resultado2 = new Resultado();
		this.cargo2 = new Cargo();
		this.campanha2 = new Campanha();
		this.partido2 = new Partido();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRetornarUmaListaDeCampanhasDeUmDeterminadoCandidato() throws SQLException {
		
		ArrayList<Campanha> listaCampanhas = new ArrayList<>();
		ArrayList<Candidato> listaCandidato = new ArrayList<>();

		
		this.candidato.setNome("CANDIDATO");
		this.candidato.setTituloEleitoral("5532424149");
		listaCandidato.add(candidato);
		
		this.resultado1.setCodigo(1);
		this.resultado1.setDescricao("NAO ELEITO");
		this.cargo1.setCodigo(2);
		this.cargo1.setDescricao("DEPUTADO DISTRITAL");
		this.partido1.setSigla("SGL");
		this.partido1.setNumero(45);
		this.campanha1.setId(1);
		this.campanha1.setAno(2002);
		this.campanha1.setNumeroCandidato(45555);
		this.campanha1.setResultado(resultado1);
		this.campanha1.setCargo(cargo1);
		this.campanha1.setPartido(partido1);
		this.campanha1.setCandidato(candidato);
		this.campanha1.setNomeDeUrna("CAND");
		this.campanha1.setUf("DF");
		this.campanha1.setDespesaMaxDeclarada((float) 450000.0);
		this.campanha1.setDespesaTotalCalculada((float) 450000.0);
		this.campanha1.setReceitaTotalCalculada((float) 450000.0);
		listaCampanhas.add(campanha1);
		
		this.resultado2.setCodigo(2);
		this.resultado2.setDescricao("ELEITO");
		this.cargo2.setCodigo(1);
		this.cargo2.setDescricao("DEPUTADO FEDERAL");
		this.partido2.setSigla("SGLL");
		this.partido2.setNumero(13);
		this.campanha2.setId(2);
		this.campanha2.setAno(2006);
		this.campanha2.setNumeroCandidato(1313);
		this.campanha2.setResultado(resultado2);
		this.campanha2.setCargo(cargo2);
		this.campanha2.setPartido(partido2);
		this.campanha2.setCandidato(candidato);
		this.campanha2.setNomeDeUrna("CAND");
		this.campanha2.setUf("DF");
		this.campanha2.setDespesaMaxDeclarada((float) 450000.0);
		this.campanha2.setDespesaTotalCalculada((float) 450000.0);
		this.campanha2.setReceitaTotalCalculada((float) 450000.0);
		listaCampanhas.add(campanha2);
		
		this.campanhaDAO.cadastrarLista(listaCampanhas);
		this.candidatoDAO.cadastrarLista(listaCandidato);
		
		Assert.assertEquals(this.campanhaDAO.getCampanhasPeloTituloEleitoral(candidato), this.campanhaControle.getListaCampanhas(candidato));
		Assert.assertEquals(this.campanhaDAO.getCampanhasPorSiglaEAno("SGLL", "2006"), this.campanhaControle.getListaCampanhasPorSiglaPartidoEAno("SGLL", "2006"));
		Assert.assertEquals(this.campanhaDAO.getPeloAnoNumeroCodCargoEUf(campanha1), this.campanhaControle.getPeloAnoNumeroCodCargoEUf(campanha1));
		Assert.assertNotEquals(this.campanhaDAO.getPeloAnoNumeroCodCargoEUf(campanha1), this.campanhaControle.getPeloAnoNumeroCodCargoEUf(campanha2));
	}

}
