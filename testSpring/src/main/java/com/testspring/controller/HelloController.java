package com.testspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testspring.model.Produit;

@Controller
public class HelloController {
	
	private static List<Produit> produits = new ArrayList<>();
	
	public HelloController() {
		Produit p1 = new Produit("1", "Produit 1", 1500);
		Produit p2 = new Produit("2", "Produit 2", 2500);
		Produit p3 = new Produit("3", "Produit 3", 3500);
		Produit p4 = new Produit("P4", "Produit 4", 12500);
		
		produits.add(p1);
		produits.add(p2);
		produits.add(p3);
		produits.add(p4);
	}
	

	// Méthode HTTP GET: pour avoir une ressource
	/* anciennement, on faisait: @RequestMapping(value = "/hello", method=RequestMethod.PUT) */
	
	@GetMapping("/hello")
	/*@ResponseBody*/
	public String helloWorld(@RequestParam(defaultValue="World!") String nom, Model model) {
		
		//return "<p>Hello World Pascal!</p>";
		model.addAttribute("nom", nom);
		return "hello";
	}
	
	@GetMapping({"/produits", "/listeProduits", "/listeproduits", "/listeDesProduits"})
	public String listeDesProduits(Model model) {
		
		model.addAttribute("produits", produits);
		
		return "listeProduits";
	}
	
}
