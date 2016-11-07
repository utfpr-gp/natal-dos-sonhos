/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean.placeholder;

/**
 * Item de produto objetivo de uma carta.
 * @author Roni
 */
public class Product {
    private String name;
    private long price;
    /*
     *     
     * Quantidade arrecadada
     *
     */
    private float raised;

    public Product() {
    }

    public Product(String name, long price, float raised) {
        this.name = name;
        this.price = price;
        this.raised = raised;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
