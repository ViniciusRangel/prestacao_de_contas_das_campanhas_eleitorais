package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import modelo.beans.Cargo;
import modelo.dao.CargoDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.campanha.CadastroCargoParse;
import teste.Template;

public class CadastroCargoParseTeste extends Template {

	private CadastroCargoParse cadastro;
	private CargoDAO cargoDAO;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	@Override
	public void beforeTest() throws Exception {
		
		this.cadastro = new CadastroCargoParse(this.tipoArquivo, this.ano);	
		this.cargoDAO = new CargoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRetornarUmCandidatoCadastrado() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[8] = "1";
		campo[9] = "CARGO TESTE";
		cadastro.executarLinhaDoArquivo(campo);
		cadastro.cadastrarInstancias();
		
		Cargo cargo = this.cargoDAO.getPeloCod(1);
		assertEquals(cargo.getCodigo().toString(), "1");
	}

}
