/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean.placeholder;

/**
 *
 * Escola originária de uma carta.
 * @author Roni
 */
public class Letter {
    
    private String title;
    private String image;
    private Child child;    
    private Product product;

    public Letter() {
    }

    public Letter(String title, String image) {
        this.title = title;
        this.image = image;        
    }   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}
