/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Roni
 */
@Entity(name = "product_items")
public class ProductItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long price;
    
    @OneToOne
    private Product product;
    /*
     *     
     * Quantidade arrecadada
     *
     */
    private float raised;

    public long getId() {
        return id;
    }
        
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public float getRaised() {
        return raised;
    }

    public void setRaised(float raised) {
        this.raised = raised;
    } 

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    /**
     * 
     * Calcula a percentagem atingida
     * 
     * @return 
     */
    public float calculatePercentage(){
        return raised/price * 100;
    }
    
}
