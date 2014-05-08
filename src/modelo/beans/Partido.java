package modelo.beans;

public class Partido {
	
	public static final String CAMPO_VAZIO = "";
	
	private String numeroPartido;
	private String sigla;
	
	public Partido() {
		this.sigla = CAMPO_VAZIO;
		this.numeroPartido = CAMPO_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) || object == null )
			return false;
		
		Partido outroPartido = (Partido) object;
		return this.sigla.equalsIgnoreCase(outroPartido.getSigla());
	}
	
	public String getNumeroPartido() {
		return numeroPartido;
	}
	
	public void setNumeroPartido(String numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}