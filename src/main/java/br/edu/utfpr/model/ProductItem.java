/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Roni
 */
@Entity(name = "product_items")
@Table(name = "product_items")
public class ProductItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private BigDecimal price;
    
    @ManyToOne
    private Product product;
    /*
     *     
     * Quantidade arrecadada
     *
     */
    private BigDecimal raised;

    public long getId() {
        return id;
    }
        
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRaised() {
        return raised;
    }

    public void setRaised(BigDecimal raised) {
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
        return raised.divide(price).multiply(new BigDecimal(100)).floatValue();
    }
    
}
