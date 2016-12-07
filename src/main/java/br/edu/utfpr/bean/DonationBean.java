/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Donation;
import br.edu.utfpr.model.Letter;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.DonationService;
import br.edu.utfpr.model.service.LetterService;
import br.edu.utfpr.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.ManyToOne;

/**
 *
 * @author vornes
 */
@ManagedBean
@ApplicationScoped
public class DonationBean {

    private Donation donation;
    private List<Donation> donationList;
    private List<Donation> pendingDonationList;
    private DonationService service;

    @ManyToOne
    private User user;

    @ManyToOne
    private Letter letter;

    public DonationBean() {
    }

    @PostConstruct
    public void init() {
        donation = new Donation();
        donationList = new ArrayList<>();
        pendingDonationList = new ArrayList<>();
        service = new DonationService();
    }

    public DonationBean(Donation donation) {
        this.donation = donation;
    }

    public Donation getDonation() {
        return donation;
    }

    public List<Donation> getDonationList() {
        return donationList;
    }

    public DonationService getService() {
        return service;
    }

    public User getUser() {
        return user;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    public void setService(DonationService service) {
        this.service = service;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public void persist() {

        if (donation.getId() == null) {
            boolean isSucess = service.save(donation);

            if (isSucess) {
                this.donationList.add(donation);
                MessageUtil.showMessage("A doação foi cadastrada com sucesso!", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Ocorreu um erro ao realizar a doação", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (service.update(donation)) {
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        }

        //limpa o formulário
        this.donation = new Donation();
    }

    public void edit(Donation donation) {
        this.donation = donation;
    }

    public void delete(Donation donation) {
        service = new DonationService();

        if (service.delete(donation)) {
            if (this.donationList.remove(donation)) {
                MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        } else {
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        }
        this.donation = new Donation();
    }

    public List<Donation> findAll() {
        return service.findAll();
    }

    public String isPayed(Donation donation){
        if(donation.getIsPayed()==false){
            return "Não está pago";
        }
        else{
            return "Pago";
        }
    }
    
    public List<Donation> pendingPayment(){
        return  service.findAllPendingPayment();
    }
}
