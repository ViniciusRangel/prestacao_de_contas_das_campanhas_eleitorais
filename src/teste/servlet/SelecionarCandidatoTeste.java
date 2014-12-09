package teste.servlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import teste.Template;
import controle.servlet.SelecionarCandidato;

public class SelecionarCandidatoTeste extends Template {

	SelecionarCandidato selecionarCandidato;
	HttpServletRequest req;
	HttpServletResponse res;
	
	@Test
	public void simulaServletComAno2002() throws Exception {
		when(req.getParameter("tituloEleitoral")).thenReturn("001364742003");
		
		this.selecionarCandidato.executa(req, res);
	}

	@Test
	public void simulaServletComAno2006() throws Exception {
		when(req.getParameter("tituloEleitoral")).thenReturn("002143582054");
		
		this.selecionarCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComAno2010() throws Exception {
		when(req.getParameter("tituloEleitoral")).thenReturn("007235102003");
		
		this.selecionarCandidato.executa(req, res);
	}

	@Override
	public void beforeTest() throws Exception {
		this.selecionarCandidato = new SelecionarCandidato();
		
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		
		this.req = mock(HttpServletRequest.class);
		this.res = mock(HttpServletResponse.class);
	}

	@Override
	public void afterTest() throws Exception {
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
	}
}
