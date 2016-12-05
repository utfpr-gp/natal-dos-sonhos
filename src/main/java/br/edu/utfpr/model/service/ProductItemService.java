/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.ProductItem;
import br.edu.utfpr.model.dao.ProductItemDAO;

/**
 *
 * @author Filipe
 */
public class ProductItemService extends AbstractService<Long, ProductItem> {
    
    public ProductItemService(){
        dao = new ProductItemDAO();
    }
}
