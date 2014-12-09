package teste.modelo.bean;

import static teste.modelo.bean.Bean.instanciarCargo;
import static teste.modelo.bean.Bean.instanciarFornecedor;
import modelo.beans.Cargo;
import modelo.beans.Fornecedor;

import org.junit.Assert;
import org.junit.Test;

public class CargoTeste {

	@Test
	public void equalsDeveRetornarVerdadeiroSeForemCargosIguais() {
		
		Cargo cargo = instanciarCargo();
		Cargo cargo2 = instanciarCargo();	
		Assert.assertTrue(cargo.equals(cargo2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemCargosDiferentes() {
		
		Cargo cargo = instanciarCargo();
		Cargo cargo2 = instanciarCargo();
		cargo2.setDescricao(Bean.STRING_TESTE_2);
		Assert.assertFalse(cargo.equals(cargo2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComCargo() {
		
		Cargo cargo = instanciarCargo();
		Fornecedor fornecedor = instanciarFornecedor();
		
		Assert.assertFalse(cargo.equals(fornecedor));
		Assert.assertFalse(fornecedor.equals(cargo));
		Assert.assertEquals(Bean.INT_TESTE,cargo.getCodigo());
		Assert.assertEquals(Bean.STRING_TESTE,fornecedor.getNome());
		Assert.assertEquals(Bean.STRING_TESTE,fornecedor.getUf());
		Assert.assertEquals(Bean.STRING_TESTE,fornecedor.getSituacaoCadastral());
	}

}
