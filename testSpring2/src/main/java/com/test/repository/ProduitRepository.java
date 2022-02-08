package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Produit;

// on va étendre une des interface de JPA (CrudRepository, JpaRepository, ...)
public interface ProduitRepository extends JpaRepository<Produit, Integer>{

}
