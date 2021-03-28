package bigExampleLab;

import java.util.Enumeration;
import java.util.Vector;


class Cliente {
	private String cpf;
	private String nome;
	private Vector compras = new Vector();
	private int pontosFrequentes;
	private double valorTotal;
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.pontosFrequentes = 0;
		this.valorTotal = 0;
	}

	public void addCompra(Compra compra) {
		compras.addElement(compra);
	}
	
	public String historico() {
		Enumeration comprasAnuncio = compras.elements();
		String resultado = "Historico de compras de anuncios por " + getNome() + "\n";
		resultado += calcularValorTotal(comprasAnuncio, resultado);
		resultado = gerarSaidaResultado(resultado);
		return resultado;
	}

	private String calcularValorTotal(Enumeration listaDeCompras, String resultado) {
		while (listaDeCompras.hasMoreElements()) {
			double totalParcial;
			
			Compra cada = (Compra) comprasAnuncio.nextElement();
			Anuncio anuncioDaCompra = cada.getAnuncio();
			Int quantidadeDiasDoAnuncio = anuncioDaCompra.getquantidadeDias();

			totalParcial = calcularValorParcial(anuncioDaCompra.getCodigoTipoAnuncio(), 0);

			this.setPontosFrequentes(this.getPontosFrequentes() + 1);
			if ((anuncioDaCompra.getCodigoTipoAnuncio() == Anuncio.VIDEO) && quantidadeDiasDoAnuncio > 1)
				pontosFrequentes++;
			resultado += "\t" + anuncioDaCompra.getDescricao() + "\t" + String.valueOf(totalParcial) + "\n";
			this.setValorTotal(this.getValorTotal() + totalParcial);
		}
		return resultado;
	}

	private double calcularValorParcial(int codigoTipoAnuncio, double totalParcial) {
		
		if (codigoTipoAnuncio == Anuncio.IMAGEM) {
			totalParcial += 2;
		} else if (codigoTipoAnuncio == Anuncio.VIDEO) {
			totalParcial += quantidadeDiasDoAnuncio * 3;
		} else if (codigoTipoAnuncio == Anuncio.TEXTO) {
			totalParcial += 1.5;
			if (quantidadeDiasDoAnuncio > 3) {
				totalParcial += (quantidadeDiasDoAnuncio - 3) * 1.5;
			}
		}
		return totalParcial;
	}

	private String gerarSaidaResultado(String resultado) {
		resultado += "Total devido é " + String.valueOf(this.valorTotal) + "\n";
		resultado += "Voce ganhou " + String.valueOf(this.pontosFrequentes) + " pontos";
		return resultado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vector getCompras() {
		return compras;
	}

	public void setCompras(Vector compras) {
		this.compras = compras;
	}

	public int getPontosFrequentes() {
		return pontosFrequentes;
	}

	public void setPontosFrequentes(int pontosFrequentes) {
		this.pontosFrequentes = pontosFrequentes;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}	
}