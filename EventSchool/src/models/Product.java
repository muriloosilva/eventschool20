package models;


public class Product {
	private int cod;
	private String descricao;
	private double valorAtual;
	private double valorAnterior;
	private int quantidadeEmEstoque;
	
	private SubCategory subCategory;
	
	private boolean emDestaque;
	
	private Imagem imagem = new Imagem();
	
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public boolean isEmDestaque() {
		return emDestaque;
	}
	public void setEmDestaque(boolean emDestaque) {
		this.emDestaque = emDestaque;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
	public double getValorAnterior() {
		return valorAnterior;
	}
	public void setValorAnterior(double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

}
