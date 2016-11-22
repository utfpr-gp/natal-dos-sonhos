/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Product;
import br.edu.utfpr.model.service.ProductService;
import br.edu.utfpr.util.MessageUtil;
import javax.annotation.PostConstruct;
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
    
    private Product product;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }   
    
    @PostConstruct
    public void init(){
        product = new Product();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }  
    
    public void doAction(){
        ProductService service = new ProductService();        
        service.save(product);   
        
        MessageUtil.showMessage("O dado foi inserido com sucesso!", "O produto " + product.getName() + " foi inserido", FacesMessage.SEVERITY_INFO);
    }    
}
