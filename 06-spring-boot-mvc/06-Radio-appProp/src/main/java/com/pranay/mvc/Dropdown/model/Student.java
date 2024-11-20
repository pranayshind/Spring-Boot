package com.pranay.mvc.Dropdown.model;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favLang;

   

    public Student() {
    }

   
    
    public Student(String firstName, String lastName, String country, String favLang) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favLang = favLang;
    }



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

}
