/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Product;
import br.edu.utfpr.model.service.ProductService;
import br.edu.utfpr.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;
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
@SessionScoped
public class ProductBean {

    private List<Product> products;
    private Product product;
    ProductService service;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }

    @PostConstruct
    public void init() {
        service = new ProductService();
        product = new Product();

        //busca todos elementos do bd
        products = service.findAll();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void persist() {

        if (product.getId() == null) {
            boolean isSucess = service.save(product);

            if (isSucess) {
                this.products.add(product);
                MessageUtil.showMessage("O dado foi inserido com sucesso!", "O produto " + product.getName() + " foi inserido", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Oppsss! Ocorreu um erro ao salvar o produto", "O produto " + product.getName() + " não foi inserido", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (service.update(product)) {
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        }

        //limpa o formulário
        this.product = new Product();

    }

    public void edit(Product product) {
        this.product = product;
    }

    public void delete(Product product) {
        System.out.println("------------------- " + product.getId() + " " + product.getName());
        service = new ProductService();
        
        if (service.delete(product)) {
            if(this.products.remove(product)){
                System.out.println("Removido da lista");
            }
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        else{
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        }
        
        //limpa o formulário
        this.product = new Product();
    }
}
