package br.edu.utfpr.model.service;

import br.edu.utfpr.model.School;
import br.edu.utfpr.model.dao.SchoolDAO;

/**
 * Created by Nadin on 05/12/16.
 */
public class SchoolService extends AbstractService<Long, School>{

    public SchoolService() {
        dao = new SchoolDAO();
    }
}
