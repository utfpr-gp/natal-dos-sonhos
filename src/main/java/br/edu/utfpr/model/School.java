/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

/**
 *
 * @author Roni
 */
public class School {
    private String name;
    private String address;
    private String professorName;

    public School() {
    }

    public School(String name, String address, String professorName) {
        this.name = name;
        this.address = address;
        this.professorName = professorName;
    }
    
    

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }  
    
}
