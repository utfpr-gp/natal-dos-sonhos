/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.bean.placeholder.Child;
import br.edu.utfpr.bean.placeholder.Letter;
import br.edu.utfpr.bean.placeholder.Product;
import br.edu.utfpr.bean.placeholder.School;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Roni
 */
@ManagedBean
@ApplicationScoped
public class LetterBean {
    
    
    private Letter letter;
    private List<Letter> letterList;
    
    /**
     * Creates a new instance of LetterBean
     */
    public LetterBean() {
    }
    
    @PostConstruct
    public void init(){
        letter = new Letter("Meu Sonho é ter uma bicicleta", null);
        School school = new School("Escola Estadual Monsenhor Pedro Busko", "Rua XV de Novembro - Guarapuava - PR", "João da Silva");
        Child child = new Child("Joãozinho", new Date(), school);
        letter.setChild(child); 
        Product product = new Product("Bicicleta", 20000, 10000);
        letter.setProduct(product);
        
        letterList = new ArrayList<>();
        letterList.add(letter);
        letterList.add(letter);
        letterList.add(letter);
                
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
    
    public boolean hasElements(){
        return !this.letterList.isEmpty();
    }
        
}
