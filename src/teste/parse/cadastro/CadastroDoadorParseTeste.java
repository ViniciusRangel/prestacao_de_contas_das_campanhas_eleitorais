package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Doador;
import modelo.dao.DoadorDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.receita_despesa.CadastroDoadorParse;
import teste.Template;

public class CadastroDoadorParseTeste extends Template {

	private CadastroDoadorParse cadastro1;
	private CadastroDoadorParse cadastro2;
	private CadastroDoadorParse cadastro3;
	private DoadorDAO doadorDAO;
	String  tipoArquivo = "receita";
	String  ano1         = "2006";
	String  ano2         = "2002";
	String  ano3         = "2010";
	
	@Override
	public void beforeTest() throws Exception {
		
		this.cadastro1 = new CadastroDoadorParse(this.tipoArquivo, this.ano1);
		this.cadastro2 = new CadastroDoadorParse(this.tipoArquivo, this.ano2);
		this.cadastro3 = new CadastroDoadorParse(this.tipoArquivo, this.ano3);
		this.doadorDAO = new DoadorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRetornarUmDoadorCadastradoPara2006() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[16] = "123";
		campo[15] = "NOME";
		campo[17] = "UF";
		campo[18] = "SITUACAO";		
		cadastro1.executarLinhaDoArquivo(campo);
		cadastro1.cadastrarInstancias();
		
		ArrayList<Doador> listaDoadores = doadorDAO.getLista();
		assertEquals(listaDoadores.get(0).getCpf_cnpj(), "123");
	}
	
	@Test
	public void deveRetornarUmDoadorCadastradoPara2002() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[6] = "12345";
		campo[8] = "NOME NOME";
		campo[7] = "UF UF";	
		cadastro2.executarLinhaDoArquivo(campo);
		cadastro2.cadastrarInstancias();
		
		ArrayList<Doador> listaDoadores = doadorDAO.getLista();
		assertEquals(listaDoadores.get(0).getCpf_cnpj(), "12345");
	}
	
	@Test
	public void deveRetornarUmDoadorCadastradoPara2010() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[10] = "12345";
		campo[11] = "NOME NOME";
		cadastro3.executarLinhaDoArquivo(campo);
		cadastro3.cadastrarInstancias();
		
		ArrayList<Doador> listaDoadores = doadorDAO.getLista();
		assertEquals(listaDoadores.get(0).getCpf_cnpj(), "12345");
	}

}
