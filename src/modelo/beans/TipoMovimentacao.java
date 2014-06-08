package modelo.beans;

public class TipoMovimentacao {
	
	public static final String STRING_VAZIO = "";
	public static final int INTEGER_VAZIO = 0;
	
	private Integer id;
	private Integer codigo;
	private String descricao;
	
	public TipoMovimentacao() {
		this.id = INTEGER_VAZIO;
		this.codigo = INTEGER_VAZIO;
		this.descricao = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof TipoMovimentacao) || object == null )
			return false;
		
		TipoMovimentacao outroTipoMovimentacao = (TipoMovimentacao) object;
		return this.descricao.equalsIgnoreCase(outroTipoMovimentacao.getDescricao());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

