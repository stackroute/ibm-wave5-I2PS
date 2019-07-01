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
    private int Experience;
    private String Skill;

    @Override
    public String toString() {
        return "SkillsAndExperience{" +
                "Experience='" + Experience + '\'' +
                ", Skill='" + Skill + '\'' +
                '}';
    }
}
