package Models;

import java.util.HashMap;
import java.util.Map;
import Models.Ingrediente;
import Models.Lanche;;


public class BD {
	public Map<String, Lanche> LanchesPadrao = new HashMap<String, Lanche>();
	public Map<String, Ingrediente> IngredientesPadrao = new HashMap<String, Ingrediente>();
	
	//Essa é a classe que vai servir como banco de dados no desafio.
	public void Bd() {
		//Ingredientes com o preço do desafio
		Ingrediente alface = new Ingrediente("Alface", 0.40);
		Ingrediente bacon = new Ingrediente("Bacon", 2.0);
		Ingrediente burguer = new Ingrediente("Burger", 3.0);
		Ingrediente ovo = new Ingrediente("Ovo", 0.80);
		Ingrediente queijo = new Ingrediente("Queijo", 1.50);
		
		//Adicionando no map os dados de ingredientes
		IngredientesPadrao.put(alface.getNome(), alface);
		IngredientesPadrao.put(bacon.getNome(), bacon);
		IngredientesPadrao.put(burguer.getNome(), burguer);
		IngredientesPadrao.put(ovo.getNome(), ovo);
		IngredientesPadrao.put(queijo.getNome(), queijo);

		//Lanches do cardápio
		Lanche XBacon = new Lanche("X-Bacon", bacon, burguer, queijo);
		Lanche XBurger = new Lanche("X-Burger", burguer, queijo);
		Lanche XEgg = new Lanche("X-Egg", ovo, burguer, queijo);
		Lanche XEggBacon = new Lanche("X-Egg Bacon", ovo, bacon, burguer, queijo);

		//Adicionando no map os dados dos lanches
		LanchesPadrao.put(XBacon.getNome(), XBacon);
		LanchesPadrao.put(XBurger.getNome(), XBurger);
		LanchesPadrao.put(XEgg.getNome(), XEgg);
		LanchesPadrao.put(XEggBacon.getNome(), XEggBacon);
	}

	public Map<String, Lanche> getLanchesPadrao() {
		return LanchesPadrao;
	}

	public void setLanchesPadrao(Map<String, Lanche> lanchesPadrao) {
		this.LanchesPadrao = lanchesPadrao;
	}

	public Map<String, Ingrediente> getIngredientesPadrao() {
		return IngredientesPadrao;
	}

	public void setIngredientesPadrao(Map<String, Ingrediente> ingredientesPadrao) {
		this.IngredientesPadrao = ingredientesPadrao;
	}
	
	
}
