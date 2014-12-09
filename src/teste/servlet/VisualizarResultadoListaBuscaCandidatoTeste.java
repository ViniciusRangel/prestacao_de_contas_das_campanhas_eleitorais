package teste.servlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import teste.Template;
import controle.servlet.VisualizarResultadoListaBuscaCandidato;

public class VisualizarResultadoListaBuscaCandidatoTeste extends Template {
	
	VisualizarResultadoListaBuscaCandidato visualizarResultadoListaBuscaCandidato;
	HttpServletRequest req;
	HttpServletResponse res;

	@Test
	public void simulaServletComVerTodosFalsoEQtdPorPaginaDiferenteDeZero() throws Exception {
		when(req.getParameter("nome")).thenReturn("a");
		when(req.getParameter("inicio")).thenReturn("0");
		when(req.getParameter("qtdPorPagina")).thenReturn("10");
		when(req.getParameter("verTodos")).thenReturn("false");
		when(req.getParameter("centro")).thenReturn("1");
		
		this.visualizarResultadoListaBuscaCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComVerTodosVerdadeiroEQtdPorPaginaIgualAZero() throws Exception {
		when(req.getParameter("nome")).thenReturn("jose");
		when(req.getParameter("inicio")).thenReturn("0");
		when(req.getParameter("qtdPorPagina")).thenReturn("0");
		when(req.getParameter("verTodos")).thenReturn("true");
		when(req.getParameter("centro")).thenReturn("1");
		
		this.visualizarResultadoListaBuscaCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComCandidatoInexistente() throws Exception {
		when(req.getParameter("nome")).thenReturn("xxysysysx");
		when(req.getParameter("inicio")).thenReturn("0");
		when(req.getParameter("qtdPorPagina")).thenReturn("0");
		when(req.getParameter("verTodos")).thenReturn("true");
		when(req.getParameter("centro")).thenReturn("1");
		
		this.visualizarResultadoListaBuscaCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComVerTodosVerdadeiroEQtdPorPaginaIgualAZeroDois() throws Exception {
		when(req.getParameter("nome")).thenReturn("jose");
		when(req.getParameter("inicio")).thenReturn("200");
		when(req.getParameter("qtdPorPagina")).thenReturn("10");
		when(req.getParameter("verTodos")).thenReturn("true");
		when(req.getParameter("centro")).thenReturn("20");
		
		this.visualizarResultadoListaBuscaCandidato.executa(req, res);
	}

	@Override
	public void beforeTest() throws Exception {
		this.visualizarResultadoListaBuscaCandidato = new VisualizarResultadoListaBuscaCandidato();
		
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		
		this.req = mock(HttpServletRequest.class);
		this.res = mock(HttpServletResponse.class);
	}

	@Override
	public void afterTest() throws Exception {
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
	}

}
