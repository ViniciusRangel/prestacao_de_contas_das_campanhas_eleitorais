package teste;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Test;

import parse.ParseException;
import controle.PartidoControle;

public class PartidoControleTeste extends Template {
	
	private PartidoDAO partidoDAO;
	private PartidoControle partidoControle;
	
	@Override
	public void beforeTest() throws Exception {
		
		this.partidoControle = new PartidoControle();
		this.partidoDAO = new PartidoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmaListaDePartidos() throws SQLException, ParseException {
		
		ArrayList<Partido> listaPartidosACadastrar = new ArrayList<>();
		ArrayList<Partido> listaPartidosRecuperados = new ArrayList<>();
		
		Partido partido1 = new Partido();
		partido1.setNome("PARTIDO EXISTENTE 1");
		partido1.setSigla("PE1");
		partido1.setNumero(46);
		partido1.setDeferimento("15.8.1996");
		listaPartidosACadastrar.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("PARTIDO EXISTENTE 2");
		partido2.setSigla("PE2");
		partido1.setNumero(78);
		partido1.setDeferimento("15.4.1995");
		listaPartidosACadastrar.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidosACadastrar);
		listaPartidosRecuperados = this.partidoDAO.getLista();
		
		assertEquals(listaPartidosRecuperados, this.partidoControle.getListaTodosPartidos());
	}
	
	@Test
	public void deveRecuperarUmPartidoPelaSigla() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		Partido partidoRecuperado = new Partido();
		
		Partido partido1 = new Partido();
		partido1.setNome("PARTIDO EXISTENTE 1");
		partido1.setSigla("PE1");
		partido1.setNumero(46);
		partido1.setDeferimento("15.8.1996");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("PARTIDO EXISTENTE 2");
		partido2.setSigla("PE2");
		partido1.setNumero(78);
		partido1.setDeferimento("15.4.1995");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		partidoRecuperado = this.partidoDAO.getPelaSigla("PE1");
		
		assertEquals(partidoRecuperado, this.partidoControle.getPelaSigla("PE1"));
	}
	
	@Test
	public void deveRecuperarUmPartidoPeloNumero() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		Partido partidoRecuperado = new Partido();
		
		Partido partido1 = new Partido();
		partido1.setNome("PARTIDO EXISTENTE 3");
		partido1.setSigla("PE3");
		partido1.setNumero(47);
		partido1.setDeferimento("15.8.1985");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("PARTIDO EXISTENTE 4");
		partido2.setSigla("PE4");
		partido1.setNumero(78);
		partido1.setDeferimento("15.5.1996");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		partidoRecuperado = this.partidoDAO.getPeloNumero("47");
		
		assertEquals(partidoRecuperado, this.partidoControle.getPeloNumero("47"));
	}
	
}
