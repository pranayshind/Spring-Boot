package com.pranay.mvc.Dropdown.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favLang;
    private List<String> tech; //becuase it is chckbox so it has multiple values

  

   



    public Student() {
    }

 
    
    // public Student(String firstName, String lastName, String country, String favLang,List<String> tech) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.country = country;
    //     this.favLang = favLang;
    //     this.tech=tech;
    // }



    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFavLang() {
        return favLang;
    }

    public void setFavLang(String favLang) {
        this.favLang = favLang;
    }


    public List<String> getTech() {
        return tech;
    }



    public void setTech(List<String> tech) {
        this.tech = tech;
    }
 
}
