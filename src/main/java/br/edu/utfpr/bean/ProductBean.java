/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Product;
import br.edu.utfpr.model.service.ProductService;
import br.edu.utfpr.util.MessageUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roni
 */
@ManagedBean
@RequestScoped
public class ProductBean {
    
    private String name;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void doAction(){
        ProductService service = new ProductService();
        Product product = new Product(name);
        service.save(product);   
        
        MessageUtil.showMessage("O dado foi inserido com sucesso!", "O produto " + name + " foi inserido", FacesMessage.SEVERITY_INFO);
    }    
}
