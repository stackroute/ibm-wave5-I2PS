package com.stackroute.intelligentservice.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillsAndExperience {
    private String skills;
    private int experience;

    @Override
    public String toString() {
        return "SkillsAndExperience{" +
                "skills='" + skills + '\'' +
                ", experience=" + experience +
                '}';
    }
}
