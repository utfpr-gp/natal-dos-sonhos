/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Roni
 */
@Entity
@Table(name = "school")
public class School {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
