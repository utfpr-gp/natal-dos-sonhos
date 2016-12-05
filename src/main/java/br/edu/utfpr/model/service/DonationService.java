/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Donation;
import br.edu.utfpr.model.dao.DonationDAO;

/**
 *
 * @author vornes
 */
public class DonationService extends AbstractService<Long, Donation>{
    
    public DonationService() {
        dao = new DonationDAO();
    }
}
