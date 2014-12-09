package teste.modelo.bean;

import static org.junit.Assert.assertFalse;
import static teste.modelo.bean.Bean.instanciarCampanha;
import static teste.modelo.bean.Bean.instanciarDespesa;
import static teste.modelo.bean.Bean.instanciarDoador;
import static teste.modelo.bean.Bean.instanciarFornecedor;
import static teste.modelo.bean.Bean.instanciarMovimentacaoFinanceira;
import static teste.modelo.bean.Bean.instanciarReceita;
import modelo.beans.Campanha;
import modelo.beans.Despesa;
import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import modelo.beans.MovimentacaoFinanceira;
import modelo.beans.Receita;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovimentacaoFinanceiraTeste {

	Despesa despesa;
	Receita receita;
	Despesa despesa2;
	Receita receita2;
	
	@Before
	public void SetUp() {
		
		this.despesa = instanciarDespesa();
		this.receita = instanciarReceita();
		this.despesa2 = instanciarDespesa();
		this.receita2 = instanciarReceita();
	}

	@Test
	public void equalsDeveRetornarFalsoEmQualquerCondicao() {

		Assert.assertFalse(despesa.equals(receita));
		Assert.assertFalse(receita.equals(despesa));
		Assert.assertEquals(Bean.STRING_TESTE, despesa.getTipoDocumento());
		Assert.assertEquals(instanciarFornecedor(), despesa.getFornecedor());
		Assert.assertEquals(Bean.STRING_TESTE, receita.getReciboEleitoral());
		Assert.assertEquals(instanciarDoador(), receita.getDoador());
	}
	
	@Test
	public void equalsDeveRetornarVerdadeiro() {

		Despesa outraDespesa = despesa;
		Receita outraReceita = receita;
		
		Assert.assertFalse(despesa.equals(outraDespesa));
		Assert.assertFalse(receita.equals(outraReceita));
	}
	
	@Test
	public void equalsDeveRetornarFalsoParaOutrosCasos() {
		Doador doador2 = instanciarDoador();
		doador2.setCpf_cnpj(Bean.STRING_TESTE_2);
		
		Fornecedor fornecedor2 = instanciarFornecedor();
		fornecedor2.setCpf_cnpj(Bean.STRING_TESTE_2);	
		
		receita2.setDoador(doador2);
		despesa2.setFornecedor(fornecedor2);
		
		assertFalse(receita.equals(receita2));
		assertFalse(despesa.equals(despesa2));
		
	}
	
	@Test
	public void equalsDeveRetornarVerdadeiroSeForemMovimentacoesFinanceiraIguais() {
		
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		MovimentacaoFinanceira movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemMovimentacoesFinancierasDiferentes() {
		
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		MovimentacaoFinanceira movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Campanha campanha = instanciarCampanha();
		campanha.setNomeDeUrna(Bean.STRING_TESTE_2);
		movimentacaoFinanceira2.setCampanha(campanha);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		campanha.setNomeDeUrna(Bean.STRING_TESTE);
		movimentacaoFinanceira2.setCampanha(campanha);
		movimentacaoFinanceira2.setDescricao(Bean.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setDescricao(Bean.STRING_TESTE);
		movimentacaoFinanceira2.setFormaPagamento(Bean.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setFormaPagamento(Bean.STRING_TESTE);
		movimentacaoFinanceira2.setNumeroDocumento(Bean.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setNumeroDocumento(Bean.STRING_TESTE);
		movimentacaoFinanceira2.setTipoMovimentacao(Bean.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setTipoMovimentacao(Bean.STRING_TESTE);
		movimentacaoFinanceira2.setValor(Bean.FLOAT_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		
		Assert.assertEquals(Bean.INT_TESTE, movimentacaoFinanceira.getId());
		Assert.assertEquals(Bean.STRING_TESTE, movimentacaoFinanceira.getData());
		
		Bean bt = new Bean();
		bt.usarBeanTeste();
		
		Assert.assertEquals((float) 1000, Bean.FLOAT_TESTE,0);
		Assert.assertEquals((float) 2000, Bean.FLOAT_TESTE_2,0);
		Assert.assertEquals("String Teste", Bean.STRING_TESTE);
	}

}
