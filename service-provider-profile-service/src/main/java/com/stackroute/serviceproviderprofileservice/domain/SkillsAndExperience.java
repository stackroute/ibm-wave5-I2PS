package com.stackroute.serviceproviderprofileservice.domain;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SkillsAndExperience {
    private String skills;
    private int experience;

    public SkillsAndExperience(String skills, int experience) {
        this.skills = skills;
        this.experience = experience;
    }

    public SkillsAndExperience() {
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
