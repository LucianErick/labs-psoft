package bigExampleLab;
class Compra {
	
	private String codigo;
	private Anuncio anuncio;
	
	public Compra(String codigo, Anuncio anuncio) {
		this.codigo = codigo;
		this.anuncio = anuncio;
	}

	public String getcodigo() {
		return codigo;
	}

	public vocodigo setcodigo(String codigo) {
		this.codigo = codigo;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public vocodigo setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
}