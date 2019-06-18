package com.stackroute.domain;


import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class User {


    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String about;
    private String skills[];
    private String domain;
    private String country;
    private String state;
    private String city;
    private String ratePerHour;
    private String preferredLocation;
    private String experience;

    public User(int userId, String firstName, String lastName, String password, String about, String[] skills, String domain, String country, String state, String city, String ratePerHour, String preferredLocation, String experience) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.about = about;
        this.skills = skills;
        this.domain = domain;
        this.country = country;
        this.state = state;
        this.city = city;
        this.ratePerHour = ratePerHour;
        this.preferredLocation = preferredLocation;
        this.experience = experience;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(String ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


}