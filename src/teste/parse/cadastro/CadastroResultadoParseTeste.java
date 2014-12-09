package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import modelo.beans.Resultado;
import modelo.dao.ResultadoDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.campanha.CadastroResultadoParse;
import teste.Template;

public class CadastroResultadoParseTeste extends Template {
	
	private CadastroResultadoParse cadastro;
	private ResultadoDAO dao;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	@Override
	public void beforeTest() throws Exception {
		
		this.cadastro = new CadastroResultadoParse(this.tipoArquivo, this.ano);	
		this.dao = new ResultadoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRetornarUmResultadoCadastrado() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[40] = "25";
		campo[41] = "Resultado 25";
		cadastro.executarLinhaDoArquivo(campo);
		cadastro.cadastrarInstancias();
		
		Resultado resultado = dao.getPeloCod(25);
		assertEquals(resultado.getDescricao(), "Resultado 25");
	}

}
