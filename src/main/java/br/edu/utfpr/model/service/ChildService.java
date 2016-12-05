/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Child;
import br.edu.utfpr.model.dao.ChildDAO;

/**
 *
 * @author Filipe
 */
public class ChildService extends AbstractService<Long , Child> {
    
    public ChildService(){
        dao = new ChildDAO();
    }
}
