/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Child;
import br.edu.utfpr.model.service.ChildService;
import br.edu.utfpr.util.MessageUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Filipe
 */
@ManagedBean
@SessionScoped
public class ChildBean {

    private List<Child> childs;
    private Child child;
    ChildService service;

    public ChildBean() {

    }

    @PostConstruct
    public void init() {
        service = new ChildService();
        child = new Child();

        childs = service.findAll();
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public ChildService getService() {
        return service;
    }

    public void setService(ChildService service) {
        this.service = service;
    }

    public void persist() {

        if (child.getId() == null) {
            boolean isSucess = service.save(child);

            if (isSucess) {
                this.childs.add(child);
                MessageUtil.showMessage("O dado foi inserido com sucesso!", "A criança " + child.getName() + " foi inserido", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Oppsss! Ocorreu um erro ao salvar a criança", "A criança " + child.getName() + " não foi inserido", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (service.update(child)) {
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        }

        //limpa o formulário
        this.child = new Child();

    }

    public void edit(Child child) {
        this.child = child;
    }

    public void delete(Child child) {
        System.out.println("------------------- " + child.getId() + " " + child.getName());
        service = new ChildService();

        if (service.delete(child)) {
            if (this.childs.remove(child)) {
                System.out.println("Removido da lista");
            }
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        }

        //limpa o formulário
        this.child = new Child();
    }

}
