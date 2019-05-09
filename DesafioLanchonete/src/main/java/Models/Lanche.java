package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lanche {
	public String nome;
	
	public List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

	public Lanche(String nome, List<Ingrediente> listaIngredientes) {
		super();
		this.nome = nome;
		this.listaIngredientes = listaIngredientes;
	}

	public Lanche(String nome, Ingrediente... ingredientes) {
		super();
		this.nome = nome;
		for(Ingrediente i : ingredientes) {
			this.listaIngredientes.add(i);
		}	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public Map<String, Long> getNumeroIngredientes(){
		Map<String, Long> qtd = listaIngredientes.stream().collect(Collectors.groupingBy(Ingrediente::getNome, Collectors.counting()));
		return qtd;
	}
	
	private Ingrediente getDadosIngrediente(String nomeConsultaIngrediente) {
		List<Ingrediente> resultado = listaIngredientes.stream().filter(nome -> nome.equals(new Ingrediente(nomeConsultaIngrediente))).collect(Collectors.toList());
		return resultado.get(0);
	}
	
	public double getValorDoLanche() {
		Double precoLanche = listaIngredientes.stream().mapToDouble(i -> i.getValor()).sum();
		
		Long qtdQueijo = getNumeroIngredientes().get("Queijo");
		Long qtdBurguer = getNumeroIngredientes().get("Burguer");
		
		if(listaIngredientes.contains(new Lanche("Alface")) && !listaIngredientes.contains(new Lanche("Bacon"))) {
			precoLanche = (precoLanche * 10)/100;
		}
		
		if(getNumeroIngredientes().get("Burguer") >= 3) {
			Long qtdBurguerAPagar = qtdQueijo - qtdQueijo/3;
			precoLanche -= getDadosIngrediente("Queijo").getValor() * qtdBurguer;
			precoLanche += getDadosIngrediente("Queijo").getValor() * qtdBurguerAPagar;
		}
		
		if(getNumeroIngredientes().get("Queijo") >= 3) {
			Long qtdQueijoAPagar = qtdQueijo - qtdQueijo/3;
			precoLanche -= getDadosIngrediente("Queijo").getValor() * qtdQueijo;
			precoLanche += getDadosIngrediente("Queijo").getValor() * qtdQueijoAPagar;
		}
		return precoLanche;
	}
	
}
