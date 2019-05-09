package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Ingrediente;
import Models.Lanche;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanchoneteController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String listaLanches (Model model) {
		
		List<Lanche> lanches = new ArrayList<Lanche>();
		
		Lanche a = new Lanche("XBacon", new Ingrediente("Bacon"));
		Lanche b = new Lanche("XBacon", new Ingrediente("Bacon"));
		Lanche c = new Lanche("XEgg", new Ingrediente("Alface"));
		
		lanches.add(a);
		lanches.add(b);
		lanches.add(c);
		for(Lanche l : lanches) {
			System.out.println(l.nome);
		}
		
		
		model.addAttribute("lanches",lanches);
		
		return "index";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String AdicionarLanche(Lanche l) {
		l.nome = "XBacon";
		
		List<Ingrediente> i = new ArrayList<Ingrediente>();
		
		i.add(new Ingrediente("Alface"));
		i.add(new Ingrediente("Alface"));
		i.add(new Ingrediente("Alface"));
		i.add(new Ingrediente("Alface"));
		
		
		l.listaIngredientes = i;
		
		System.out.println(l.nome);
		
		return "redirect:/index";
	}
}
