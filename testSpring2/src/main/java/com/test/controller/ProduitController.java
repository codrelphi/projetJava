package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Produit;
import com.test.repository.ProduitRepository;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitRepository produitRepository;
	

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/save")
	public String enregistrement() {
		
		Produit p1 = new Produit("Produit 1", 1200);
		Produit p2 = new Produit("Produit 2", 2500);
		Produit p3 = new Produit("Produit 3", 3500);
		Produit p4 = new Produit("Produit 4", 4500);
		produitRepository.save(p1);
		produitRepository.save(p2);
		produitRepository.save(p3);
		produitRepository.save(p4);
		
		return "hello";
	}
	
	@GetMapping("/produits")
	public String listeDesProduits(Model model) {
		
		List<Produit> produits = produitRepository.findAll();
		model.addAttribute("produits", produits);
		
		return "listeProduits";
	}
	
	@GetMapping("/")
	public String defaultIndex() {
		return "redirect:/hello";
	}
	
	@GetMapping("/403")
	public String pasAutoriser() {
		return "403";	
	}
	
	/*@GetMapping("/login")
	public String login() {
		return "login";	
	}*/
	
	
}
