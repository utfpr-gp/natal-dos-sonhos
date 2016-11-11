/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Letter;
import br.edu.utfpr.model.dao.LetterDAO;

/**
 *
 * @author Roni
 */
public class LetterService extends AbstractService<Long, Letter>{

    public LetterService() {
        dao = new LetterDAO();
    }
        
}
