/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Child;
import br.edu.utfpr.model.Letter;
import br.edu.utfpr.model.Letter;
import br.edu.utfpr.model.Product;
import br.edu.utfpr.model.ProductItem;
import br.edu.utfpr.model.School;
import br.edu.utfpr.model.service.ChildService;
import br.edu.utfpr.model.service.LetterService;
import br.edu.utfpr.model.service.LetterService;
import br.edu.utfpr.model.service.ProductItemService;
import br.edu.utfpr.model.service.ProductService;
import br.edu.utfpr.util.MessageUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.OneToOne;

/**
 *
 * @author Roni
 */
@ManagedBean
@SessionScoped
public class LetterBean {

    private Letter letter;
    private List<Letter> letterList;
    private LetterService service;

    @OneToOne
    private Long childId;
    private Long productItemId;

    /**
     * Creates a new instance of LetterBean
     */
    public LetterBean() {
    }

    @PostConstruct
    public void init() {
        letter = new Letter();
        letterList = new ArrayList<>();
        service = new LetterService();
        letterList = service.findAll();
    }

    public LetterBean(Letter letter) {
        this.letter = letter;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public List<Letter> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<Letter> letterList) {
        this.letterList = letterList;
    }

    public boolean hasElements() {
        return !this.letterList.isEmpty();
    }

    public LetterService getService() {
        return service;
    }

    public void setService(LetterService service) {
        this.service = service;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(Long productItemId) {
        this.productItemId = productItemId;
    }

    public void persist() {

        if (letter.getId() == null) {
            ChildService c = new ChildService();
            Child child = c.getById(childId);
            letter.setChild(child);
            ProductItemService p = new ProductItemService();
            ProductItem productItem = p.getById(productItemId);
            letter.setProductItem(productItem);
            boolean isSucess = service.save(letter);

            if (isSucess) {
                this.letterList.add(letter);
                MessageUtil.showMessage("O dado foi inserido com sucesso!", "A carta de título " + letter.getTitle() + " foi inserido", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Oppsss! Ocorreu um erro ao salvar a carta", "A carta de título " + letter.getTitle() + " não foi inserido", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (service.update(letter)) {
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        }

        //limpa o formulário
        this.letter = new Letter();

    }

    public void edit(Letter letter) {
        this.letter = letter;
    }

    public void delete(Letter letter) {
        System.out.println("------------------- " + letter.getId() + " " + letter.getTitle());
        service = new LetterService();

        if (service.delete(letter)) {
            if (this.letterList.remove(letter)) {
                System.out.println("Removido da lista");
            }
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        }

        //limpa o formulário
        this.letter = new Letter();
    }
    
    public List<Letter> findAll(){
        return letterList = service.findAll();
    }
    
    public String doAction(Letter letter){
        this.letter = letter;
        return "letter-details";
    }
}
