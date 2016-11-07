/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Roni
 */
@ManagedBean
@RequestScoped
public class UserBean {

    /**
     * Creates a new instance of userBean
     */
    public UserBean() {
    }
    
    public void showMessage(String resume, String detail, FacesMessage.Severity type){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(type, resume, detail);
        context.addMessage(null, facesMessage);        
    }
    
}
