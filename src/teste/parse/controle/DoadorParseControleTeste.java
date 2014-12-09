package teste.parse.controle;

import modelo.beans.Doador;
import modelo.dao.DoadorDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.controle.DoadorParseControle;
import parse.indices.DoadorIndicesParse;
import teste.Template;

public class DoadorParseControleTeste extends Template {

	public static final int CPF_CNPJ = 0;
	public static final int NOME = 1;
	public static final int UF = 2;
	public static final int SITUACAO_CADASTRAL = 3;
	
	private String campo[];
	private DoadorDAO doadorDAO;
	private DoadorIndicesParse doadorIndicesParse;
	private DoadorParseControle doadorParseControle;

	@Override
	public void beforeTest() throws Exception {
		
		this.campo = new String[4];
		this.doadorDAO = new DoadorDAO();
		this.doadorIndicesParse = new DoadorIndicesParse();
		this.doadorParseControle = new DoadorParseControle(this.doadorIndicesParse);
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void cadastrarDoadores() throws Exception {
		
		this.doadorParseControle.addInstancia(campo);
		this.doadorParseControle.cadastrarInstancias();
		this.doadorParseControle.resetar();
		
		Doador doadorCadastrado = this.doadorDAO.getLista().get(0);
				
		Assert.assertEquals(this.campo[CPF_CNPJ], doadorCadastrado.getCpf_cnpj() );
		Assert.assertEquals(this.campo[NOME], doadorCadastrado.getNome());
		Assert.assertEquals(this.campo[UF], doadorCadastrado.getUf());
		Assert.assertEquals(this.campo[SITUACAO_CADASTRAL], doadorCadastrado.getSituacaoCadastral());
	}
	
	@Test
	public void naoDeveCadastrarDoisDoadoresIguais() throws Exception {
		
		this.doadorParseControle.addInstancia(campo);
		this.doadorParseControle.addInstancia(campo);
		this.doadorParseControle.cadastrarInstancias();
		this.doadorParseControle.resetar();
		
		int numeroDoadoresCadastrados = this.doadorDAO.getLista().size();
		
		Assert.assertEquals(1, numeroDoadoresCadastrados);
	}
	
	private void iniciarIndices() {
		
		this.doadorIndicesParse.setIndiceCpf_Cnpj(CPF_CNPJ);
		this.doadorIndicesParse.setIndiceNome(NOME);
		this.doadorIndicesParse.setIndiceUf(UF);
		this.doadorIndicesParse.setIndiceSituacaoCadastral(SITUACAO_CADASTRAL);
	}
	
	private void iniciarCampos() {
		
		this.campo[CPF_CNPJ] = "55325424149";
		this.campo[NOME] = "DOADOR INEXISTENTE";
		this.campo[UF] = "DF";
		this.campo[SITUACAO_CADASTRAL] = "REGULAR";
	}

}
