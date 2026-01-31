package com.example.demo.user;

public class User {


    private  int id;
    private String firstname;
    private  String lastname;
    private String email;
    private Address address;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String firstname,String lastname, String email , Address address){
        this.address=address;
        this.id=id;
        this.email=email;
        this.firstname=firstname;
        this.lastname=lastname;
    }


}
