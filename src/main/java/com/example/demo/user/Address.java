package com.example.demo.user;

public class Address {
    private String Street;
    private int zip ;
    private String city;
    private  String Country;


    public Address(String Street, int zip, String city, String Country){
        this.city=city;
        this.Country=Country;
        this.zip=zip;
        this.Street=Street;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return Country;
    }

    public String getStreet() {
        return Street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
