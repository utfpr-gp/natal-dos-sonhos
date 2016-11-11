/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.util.Date;

/**
 *
 * @author Roni
 */
public class Child {
    private String name;
    private Date birthday;
    private School school;

    public Child() {
    }

    public Child(String name, Date birthday, School school) {
        this.name = name;
        this.birthday = birthday;
        this.school = school;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
    
}
