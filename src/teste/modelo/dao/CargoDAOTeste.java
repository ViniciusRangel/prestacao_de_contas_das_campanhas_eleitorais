package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Cargo;
import modelo.dao.CargoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.Template;

public class CargoDAOTeste extends Template {

	private CargoDAO cargoDAO;

	@Override
	public void beforeTest() throws Exception {
		
		this.cargoDAO = new CargoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRecuperarUmCargoPeloCodigo() throws SQLException {

		ArrayList<Cargo> listaCargos = new ArrayList<>();
		Cargo cargoRecuperado = new Cargo();

		Cargo c1 = new Cargo();
		c1.setCodigo(1);
		c1.setDescricao("CARGO UM");
		listaCargos.add(c1);

		Cargo c2 = new Cargo();
		c2.setCodigo(2);
		c2.setDescricao("CARGO DOIS");
		listaCargos.add(c2);

		this.cargoDAO.cadastrarLista(listaCargos);

		cargoRecuperado = this.cargoDAO.getPeloCod(1);
		Assert.assertEquals(c1, cargoRecuperado);
	}
	
	@Test
	public void deveRecuperarUmCargoPelaDescricao() throws SQLException {

		ArrayList<Cargo> listaCargos = new ArrayList<>();
		Cargo cargoRecuperado = new Cargo();

		Cargo c1 = new Cargo();
		c1.setCodigo(1);
		c1.setDescricao("CARGO UM");
		listaCargos.add(c1);

		Cargo c2 = new Cargo();
		c2.setCodigo(2);
		c2.setDescricao("CARGO DOIS");
		listaCargos.add(c2);

		this.cargoDAO.cadastrarLista(listaCargos);

		cargoRecuperado = this.cargoDAO.getPelaDescricao("CARGO UM");
		Assert.assertEquals(c1, cargoRecuperado);
	}
	
	@Test
	public void deveRecuperarUmaListaDeCargos() throws SQLException {
		
		ArrayList<Cargo> listaCargos = new ArrayList<>();
		ArrayList<Cargo> listaRecuperada = new ArrayList<>();
		
		Cargo c1 = new Cargo();
		c1.setCodigo(1);
		c1.setDescricao("CARGO UM");
		listaCargos.add(c1);

		Cargo c2 = new Cargo();
		c2.setCodigo(2);
		c2.setDescricao("CARGO DOIS");
		listaCargos.add(c2);
		
		Cargo c3 = new Cargo();
		c3.setCodigo(3);
		c3.setDescricao("CARGO TRES");
		listaCargos.add(c3);
		
		this.cargoDAO.cadastrarLista(listaCargos);
		listaRecuperada = this.cargoDAO.getLista();
		
		Assert.assertEquals(listaRecuperada, this.cargoDAO.getLista());
	}

	@Test
	public void valoresComparacao() throws Exception {

		Cargo c1 = new Cargo();
		Cargo c2 = new Cargo();
		c1.setCodigo(1);
		c2.setCodigo(2);
		int resultado;

		resultado = CargoDAO.Comparacao.CODIGO.compare(c1, c2);

		Assert.assertNotEquals(0, resultado);
	}

}
