package teste.modelo.bean;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import modelo.beans.MovimentacaoFinanceira;
import modelo.beans.Partido;
import modelo.beans.Receita;
import modelo.beans.Resultado;

public class Bean {
	
	Bean() {}
	public void usarBeanTeste() {}
	
	public static final Integer INT_TESTE = 50;
	public static final Integer INT_TESTE_2 = 60;
	public static final float FLOAT_TESTE = 1000;
	public static final float FLOAT_TESTE_2 = 2000;
	public static final String STRING_TESTE = "String Teste";
	public static final String STRING_TESTE_2 = "String Teste Dois";
	
	public static Campanha instanciarCampanha() {
		
		Campanha campanha = new Campanha();
		campanha.setAno(INT_TESTE);
		campanha.setCandidato(instanciarCandidato());
		campanha.setCargo(instanciarCargo());
		campanha.setDespesaMaxDeclarada(FLOAT_TESTE);
		campanha.setDespesaTotalCalculada(FLOAT_TESTE);
		campanha.setId(INT_TESTE);
		campanha.setNomeDeUrna(STRING_TESTE); 
		campanha.setNumeroCandidato(INT_TESTE);
		campanha.setPartido(instanciarPartido());
		campanha.setReceitaTotalCalculada(FLOAT_TESTE);
		campanha.setResultado(instanciarResultado());
		campanha.setUf(STRING_TESTE);
		
		return campanha;
	}
	
	public static Candidato instanciarCandidato() {
		
		Candidato candidato = new Candidato();
		candidato.setNome(STRING_TESTE);
		candidato.setTituloEleitoral(STRING_TESTE);
		
		return candidato;
	}
	
	public static Cargo instanciarCargo() {
		
		Cargo cargo = new Cargo();
		cargo.setCodigo(INT_TESTE);
		cargo.setDescricao(STRING_TESTE);
		
		return cargo;
	}
	
	public static Despesa instanciarDespesa() {
		
		Despesa despesa = new Despesa();
		despesa.setCampanha(instanciarCampanha());
		despesa.setData(STRING_TESTE);
		despesa.setDescricao(STRING_TESTE);
		despesa.setFormaPagamento(STRING_TESTE);
		despesa.setFornecedor(instanciarFornecedor());
		despesa.setId(INT_TESTE);
		despesa.setNumeroDocumento(STRING_TESTE);
		despesa.setTipoDocumento(STRING_TESTE);
		despesa.setTipoMovimentacao(STRING_TESTE);
		despesa.setValor(FLOAT_TESTE);
		
		return despesa;
	}
	
	public static Doador instanciarDoador() {
		
		Doador doador = new Doador();
		doador.setCpf_cnpj(STRING_TESTE);
		doador.setNome(STRING_TESTE);
		doador.setSituacaoCadastral(STRING_TESTE);
		doador.setUf(STRING_TESTE);
		
		return doador;		
	}
	
	public static Fornecedor instanciarFornecedor() {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCpf_cnpj(STRING_TESTE);
		fornecedor.setNome(STRING_TESTE);
		fornecedor.setSituacaoCadastral(STRING_TESTE);
		fornecedor.setUf(STRING_TESTE);
		
		return fornecedor;
	}
	
	public static MovimentacaoFinanceira instanciarMovimentacaoFinanceira() {
		
		MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
		movimentacaoFinanceira.setCampanha(instanciarCampanha());
		movimentacaoFinanceira.setData(STRING_TESTE);
		movimentacaoFinanceira.setDescricao(STRING_TESTE);
		movimentacaoFinanceira.setFormaPagamento(STRING_TESTE);
		movimentacaoFinanceira.setId(INT_TESTE);
		movimentacaoFinanceira.setNumeroDocumento(STRING_TESTE);
		movimentacaoFinanceira.setTipoMovimentacao(STRING_TESTE);
		movimentacaoFinanceira.setValor(FLOAT_TESTE);
		
		return movimentacaoFinanceira;
	}
	
	public static Partido instanciarPartido() {
		
		Partido partido = new Partido();
		partido.setDeferimento(STRING_TESTE);
		partido.setNome(STRING_TESTE);
		partido.setNumero(INT_TESTE);
		partido.setSigla(STRING_TESTE);
		
		return partido;
	}
	
	public static Receita instanciarReceita() {
		
		Receita receita = new Receita();
		receita.setCampanha(instanciarCampanha());
		receita.setData(STRING_TESTE);
		receita.setDescricao(STRING_TESTE);
		receita.setDoador(instanciarDoador());
		receita.setFormaPagamento(STRING_TESTE);
		receita.setId(INT_TESTE);
		receita.setNumeroDocumento(STRING_TESTE);
		receita.setReciboEleitoral(STRING_TESTE);
		receita.setTipoMovimentacao(STRING_TESTE);
		receita.setValor(FLOAT_TESTE);

		return receita;
	}
	
	public static Resultado instanciarResultado() {
		
		Resultado resultado = new Resultado();
		resultado.setCodigo(INT_TESTE);
		resultado.setDescricao(STRING_TESTE);
		
		return resultado;
	}
	
}
