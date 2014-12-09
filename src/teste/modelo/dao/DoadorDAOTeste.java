package teste.modelo.dao;

import java.util.ArrayList;

import modelo.beans.Doador;
import modelo.dao.DoadorDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.Template;

public class DoadorDAOTeste extends Template {

	private DoadorDAO doadorDAO;
	
	@Override
	public void beforeTest() throws Exception {
		
		this.doadorDAO = new DoadorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void valoresComparacaoParteI() throws Exception {
		
		Doador D1 = new Doador();
		Doador D2 = new Doador();
		D1.setCpf_cnpj("1234567");
		D2.setCpf_cnpj("1234567");
		int resultado;

		resultado = DoadorDAO.Comparacao.NOME.compare(D1, D2);
		
		Assert.assertEquals(0,resultado);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmDoadorInexistente() throws Exception {
		
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		listaDoadores.add(doador);
		
		this.doadorDAO.cadastrarLista(listaDoadores);
	}
	
	@Test
	public void naoDeveCadastrarUmDoadorJaExistente() throws Exception {
		
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		listaDoadores.add(doador);

		this.doadorDAO.cadastrarLista(listaDoadores);
		this.doadorDAO.cadastrarLista(listaDoadores);
		
		Assert.assertEquals(1, this.doadorDAO.getLista().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsDoadoresCadastrados() throws Exception {
		
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		doador.setCpf_cnpj("123");
		doador.setSituacaoCadastral("Cadastrado");
		doador.setUf("DF");
		listaDoadores.add(doador);
		
		doador = new Doador();
		doador.setNome("Nome2");
		doador.setCpf_cnpj("1234");
		doador.setSituacaoCadastral("Cadastrado");
		doador.setUf("DF");
		listaDoadores.add(doador);

		this.doadorDAO.cadastrarLista(listaDoadores);
		Assert.assertEquals(listaDoadores, this.doadorDAO.getLista());
	}
	
	@Test
	public void deveRecuperarUmDoadorPeloNomeOuCpfCnpj() throws Exception {
		
		ArrayList<Doador> listaDoadoresACadastrar = new ArrayList<>();
		Doador doadorRecuperado;
		
		Doador doador1 = new Doador();
		doador1.setNome("nome");
		doador1.setCpf_cnpj("123456");
		doador1.setSituacaoCadastral("REGULAR");
		doador1.setUf("DF");
		listaDoadoresACadastrar.add(doador1);
		
		Doador doador2 = new Doador();
		doador2.setNome("nome2");
		doador2.setCpf_cnpj("12345678");
		doador2.setSituacaoCadastral("IRREGULAR");
		doador2.setUf("DF");
		listaDoadoresACadastrar.add(doador2);
		
		this.doadorDAO.cadastrarLista(listaDoadoresACadastrar);
		doadorRecuperado = this.doadorDAO.getPeloNomeOuCpfCnpj(doador1);
		
		Assert.assertEquals(doador1, doadorRecuperado);
	}
	
}
