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
    private int experience;
    private String skill;

    @Override
    public String toString() {
        return "SkillsAndExperience{" +
                "experience='" + experience+ '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
