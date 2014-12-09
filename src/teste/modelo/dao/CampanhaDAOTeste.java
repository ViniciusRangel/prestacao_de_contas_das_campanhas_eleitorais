package teste.modelo.dao;

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

import teste.Template;

public class CampanhaDAOTeste extends Template {
	
	private CampanhaDAO campanhaDAO;
	private CandidatoDAO candidatoDAO;
	private Resultado resultado1;
	private Cargo cargo;
	private Partido partido1;
	private Candidato candidato1;
	private Resultado resultado2;
	private Partido partido2;
	private Candidato candidato2;
	private ArrayList<Campanha> listaCampanhas;

	@Override
	public void beforeTest() throws Exception {
		
		this.campanhaDAO = new CampanhaDAO();
		this.candidatoDAO = new CandidatoDAO();
		this.resultado1 = new Resultado();
		this.cargo = new Cargo();
		this.partido1 = new Partido();
		this.candidato1 = new Candidato();
		this.resultado2 = new Resultado();
		this.partido2 = new Partido();
		this.candidato2 = new Candidato();
		this.listaCampanhas = new ArrayList<>();

		cadastraNoBanco();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	private void cadastraNoBanco() throws SQLException {

		ArrayList<Candidato> listaCandidato = new ArrayList<>();
		
		Campanha camp1 = new Campanha();
		this.resultado1.setCodigo(2);
		this.cargo.setCodigo(1);
		this.partido1.setNumero(45);
		this.candidato1.setTituloEleitoral("55325424149");
		camp1.setId(1);
		camp1.setAno(2006);
		camp1.setNumeroCandidato(45555);
		camp1.setResultado(resultado1);
		camp1.setCargo(cargo);
		camp1.setPartido(partido1);
		camp1.setCandidato(candidato1);
		camp1.setNomeDeUrna("NOME DE URNA UM");
		camp1.setUf("DF");
		camp1.setDespesaMaxDeclarada((float) 450000.);
		camp1.setDespesaTotalCalculada((float) 450000.0);
		camp1.setReceitaTotalCalculada((float) 450000.0);
		listaCampanhas.add(camp1);
		listaCandidato.add(candidato1);
		
		Campanha camp2 = new Campanha();
		this.resultado2.setCodigo(3);
		this.partido2.setNumero(13);
		this.candidato2.setTituloEleitoral("04725698130");
		camp2.setId(2);
		camp2.setAno(2006);
		camp2.setNumeroCandidato(13122);
		camp2.setResultado(resultado2);
		camp2.setCargo(cargo);
		camp2.setPartido(partido2);
		camp2.setCandidato(candidato2);
		camp2.setNomeDeUrna("NOME DE URNA DOIS");
		camp2.setUf("DF");
		camp2.setDespesaMaxDeclarada((float) 500000.);
		camp2.setDespesaTotalCalculada((float) 500000.0);
		camp2.setReceitaTotalCalculada((float) 500000.0);
		listaCampanhas.add(camp2);
		listaCandidato.add(candidato2);
		
		this.candidatoDAO.cadastrarLista(listaCandidato);				
		this.campanhaDAO.cadastrarLista(listaCampanhas);
	}
	
	@Test
	public void deveVerificarSeOTopFiveEstaOrdenado() throws SQLException {	
		
		Assert.assertEquals(listaCampanhas, this.campanhaDAO.getLista());
	}
	
	@Test
	public void deveListarCandidatosPorOrdemDeDespesa() throws Exception {
		
		ArrayList<Campanha> listaTop1= this.campanhaDAO.TopFive("presidente",2006);
		Assert.assertTrue(listaTop1.get(0).getDespesaMaxDeclarada() >= listaTop1.get(1).getDespesaMaxDeclarada());
		
		//ArrayList<Campanha> listaTop2 = this.campanhaDAO.TopFive("senador",2010);
		//Assert.assertTrue(listaTop2.get(0).getDespesaMaxDeclarada() >= listaTop2.get(1).getDespesaMaxDeclarada());
		
		//ArrayList<Campanha> listaTop3 = this.campanhaDAO.TopFive("governador",2002);
		//Assert.assertTrue(listaTop3.get(0).getDespesaMaxDeclarada() >= listaTop3.get(1).getDespesaMaxDeclarada());
	}

}
