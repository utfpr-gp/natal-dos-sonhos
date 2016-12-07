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
    private String teacherName;
    private Integer addressNumber;
    private String neighborhood;
    private String city;
    
  
    public School(String name, String address, String teacherName, Integer addressNumber, String neighborhood, String city) {
        this.name = name;
        this.address = address;
        this.teacherName = teacherName;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public School() {
    }

    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getteacherName() {
        return teacherName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
