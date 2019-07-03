package com.stackroute.intelligentservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
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
