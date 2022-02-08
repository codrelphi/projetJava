package com.testspring.model;


public class Produit {

	private String code;
	private String description;
	private double prix;
	
	private static final double PRIXINITIAL = 5;
	private static final String DESCRIPTIONINITIALE = "Non mentionnée";
	
	public Produit() {
		this.code = "C0";
		this.prix = PRIXINITIAL;
	}
	
	public Produit(String pCode) {
		this.code = pCode;
		this.description = Produit.DESCRIPTIONINITIALE;
		this.prix = Produit.PRIXINITIAL;
	}
	
	public Produit(String pCode, String pDescription) {
		this.code = pCode;
		this.description = pDescription;
		this.prix = Produit.PRIXINITIAL;
	}
	
	public Produit(String pCode, String pDescription, double pPrix) {
		this.code = pCode;
		this.description = pDescription;
		this.prix = pPrix;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		
		System.out.println("Code:\t" + this.getCode());
		System.out.println("Description:" + this.getDescription());
		System.out.println("Prix:\t" + this.getPrix() + " Euros");
		
		return "";
	}
	
}
