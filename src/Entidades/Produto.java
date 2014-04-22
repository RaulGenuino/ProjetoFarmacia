package Entidades;

public class Produto {
	
	private String nome;
	private String tipo;
	private String codigoBarras;
	private double precoDeVenda;
	private double precoDeCusto;
	private int quantProdutos;
	private boolean disponivelParaVendas;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public double getPrecoDeCusto() {
		return precoDeCusto;
	}
	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}
	public int getQuantProdutos() {
		return quantProdutos;
	}
	public void setQuantProdutos(int quantProdutos) {
		this.quantProdutos = quantProdutos;
	}
	public boolean isDisponivelParaVendas() {
		return disponivelParaVendas;
	}
	public void setDisponivelParaVendas(boolean disponivelParaVendas) {
		this.disponivelParaVendas = disponivelParaVendas;
	}

}
