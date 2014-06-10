package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import modelo.dao.DoadorDAO;
import modelo.dao.FornecedorDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class FornecedorDAOTeste extends TemplateTeste {

	private FornecedorDAO fornecedorDAO;
	
	@Override
	public void beforeTest() throws Exception {
		this.fornecedorDAO = new FornecedorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void valoresComparacao() throws Exception {
		//FornecedorDAO.Comparacao.valueOf(FornecedorDAO.Comparacao.NOME.toString());
		
		Fornecedor F1 = new Fornecedor();
		Fornecedor F2 = new Fornecedor();
		F1.setCpf_cnpj("123");
		F2.setCpf_cnpj("123");
		int resultado;

		resultado = FornecedorDAO.Comparacao.CPF_CNPJ.compare(F1, F2);
		
		Assert.assertEquals(0,resultado);
	}
	

	@Test
	public void valoresComparacaoParteII() throws Exception {
		//FornecedorDAO.Comparacao.valueOf(FornecedorDAO.Comparacao.NOME.toString());
		
		Fornecedor F1 = new Fornecedor();
		Fornecedor F2 = new Fornecedor();
		F1.setCpf_cnpj("124");
		F2.setCpf_cnpj("125");
		int resultado;

		resultado = FornecedorDAO.Comparacao.CPF_CNPJ.compare(F1, F2);
		
		Assert.assertEquals(-1,resultado);
		
	}
	
	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmFornecedorInexistente() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		listaFornecedores.add(fornecedor);
		
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
	}
	
	@Test
	public void naoDeveCadastrarUmFornecedorJaExistente() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		listaFornecedores.add(fornecedor);

		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		
		Assert.assertEquals(1, this.fornecedorDAO.getLista().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsFornecedoresCadastrados() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		fornecedor.setCpf_cnpj("123");
		fornecedor.setSituacaoCadastral("Cadastrado");
		fornecedor.setUf("DF");
		listaFornecedores.add(fornecedor);
		
		fornecedor = new Fornecedor();
		fornecedor.setNome("Nome2");
		fornecedor.setCpf_cnpj("1234");
		fornecedor.setSituacaoCadastral("Cadastrado");
		fornecedor.setUf("DF");
		listaFornecedores.add(fornecedor);

		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		Assert.assertEquals(listaFornecedores, this.fornecedorDAO.getLista());
	}	
}