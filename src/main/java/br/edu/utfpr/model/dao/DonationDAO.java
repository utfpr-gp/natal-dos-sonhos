/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.dao;

import br.edu.utfpr.model.Donation;
import br.edu.utfpr.model.Letter;
import br.edu.utfpr.util.JPAUtil;
import java.util.List;

/**
 *
 * @author vornes
 */
public class DonationDAO extends AbstractDAO<Long, Donation>{
    
        public List<Donation> findAllPendingPayment() {
        this.entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery(("FROM " + getTypeClass().getName() + " WHERE isPayed = false"))
                .getResultList();
    }
    
}
