package com.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/* ce modèle est une entité JPA */

@Entity
public class Produit implements Serializable {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String description;
	private double prix;
	
	public Produit() {}

	public Produit(String description, double prix) {
		this.description = description;
		this.prix = prix;
	}
	
	public Produit(int code, String description, double prix) {
		this.code = code;
		this.description = description;
		this.prix = prix;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
		return "Produit [code=" + code + ", description=" + description + ", prix=" + prix + "]";
	}
	
	

}
