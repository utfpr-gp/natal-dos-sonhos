/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.MessageUtil;
import java.util.List;
import javax.annotation.PostConstruct;
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

    private User user;
    private UserService service;
    private List<User> users;

    /**
     * Creates a new instance of userBean
     */
    public UserBean() {
    }

    @PostConstruct
    public void init() {
        service = new UserService();
        user = new User();

        users = service.findAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void persist() {

        if (user.getId() == null) {
            boolean isSucess = service.save(user);

            if (isSucess) {
                this.users.add(user);
                MessageUtil.showMessage("O usuário foi cadastrado com sucesso!", "O usuário " + user.getName() + " foi inserido", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Oppsss! Ocorreu um erro ao salvar o usuário", "O usuário " + user.getName() + " não foi inserido", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (service.update(user)) {
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        }

        //limpa o formulário
        this.user = new User();

    }

    public void edit(User user) {
        this.user = user;
    }

    public void delete(User user) {
        System.out.println("------------------- " + user.getId() + " " + user.getName());
        service = new UserService();

        if (service.delete(user)) {
            if (this.users.remove(user)) {
                System.out.println("Removido da lista");
            }
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        }

        //limpa o formulário
        this.user = new User();
    }

}
