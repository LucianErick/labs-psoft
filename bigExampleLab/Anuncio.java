package bigExampleLab;
public class Anuncio {
	
	public static final int IMAGEM = 0;
	public static final int VIDEO = 1;
	public static final int TEXTO = 2;

	private String codigoAnuncio;
	private int codigoTipoAnuncio;
	private String descricao;
	private int quantidadeDias;

	public Anuncio(String codigoAnuncio, String descricao, int codigoTipoAnuncio, int quantidadeDias) {
		this.codigoAnuncio = codigoAnuncio;
		this.descricao = descricao;
		this.codigoTipoAnuncio = codigoTipoAnuncio;
		this.quantidadeDias = quantidadeDias;
	}

	public int getCodigoTipoAnuncio() {
		return codigoTipoAnuncio;
	}
	public void setCodigoTipoAnuncio(int novoCodigo) {
		codigoTipoAnuncio = novoCodigo;
	}
	public String getDescricao (){
		return descricao;
	}
	public int getquantidadeDias() {
		return quantidadeDias;
	}
	public void setquantidadeDias(int quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public String getCodigoAnuncio() {
		return codigoAnuncio;
	}

	public void setCodigoAnuncio(String codigoAnuncio) {
		this.codigoAnuncio = codigoAnuncio;
	}

	
}