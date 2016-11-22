/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Item de produto objetivo de uma carta.
 * @author Roni
 */
@Entity(name = "products")
@Table(name="products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    @Column(name = "item_id")
    private Set<ProductItem> productItems;
    
    private String name;
        
    private String image;
      

    public Product() {
    }

    public Product(String name) {
        this.name = name;        
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(Set<ProductItem> productItems) {
        this.productItems = productItems;
    }
    
    
    
    
    
    
    

    
}
