package teste.modelo.bean;

import static teste.modelo.bean.Bean.instanciarCandidato;
import static teste.modelo.bean.Bean.instanciarPartido;
import modelo.beans.Candidato;
import modelo.beans.Partido;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTeste {

	@Test
	public void equalsDeveRetornarVerdadeiroSeForemCandidatosIguais() {
		
		Candidato candidato = instanciarCandidato();
		Candidato candidato2 = instanciarCandidato();
		Assert.assertTrue(candidato.equals(candidato2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemCandidatosDiferentes() {
		
		Candidato candidato = instanciarCandidato();
		Candidato candidato2 = instanciarCandidato();
		candidato2.setTituloEleitoral(Bean.STRING_TESTE_2);
		Assert.assertFalse(candidato.equals(candidato2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComCandidato() {
		
		Candidato candidato = instanciarCandidato();
		Partido partido = instanciarPartido();
		Assert.assertFalse(candidato.equals(partido));
		Assert.assertFalse(partido.equals(candidato));
		
		Assert.assertEquals(Bean.STRING_TESTE,candidato.getNome());
		
		Assert.assertEquals(Bean.STRING_TESTE,partido.getSigla());
		Assert.assertEquals(Bean.STRING_TESTE,partido.getDeferimento());
		Assert.assertEquals(Bean.STRING_TESTE,partido.getNome());
	}

}
