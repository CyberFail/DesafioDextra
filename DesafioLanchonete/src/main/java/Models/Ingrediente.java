package Models;

public class Ingrediente {
	public String nome;	
	public Double valor;
	
	public Ingrediente(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public Ingrediente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
