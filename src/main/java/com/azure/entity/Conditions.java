package com.azure.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conditions")
public class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conditions;
    private String conditionsAnswer;
    private String conditionsType;


    @ManyToOne
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getConditionsAnswer() {
        return conditionsAnswer;
    }

    public void setConditionsAnswer(String conditionsAnswer) {
        this.conditionsAnswer = conditionsAnswer;
    }

    public String getConditionsType() {
        return conditionsType;
    }

    public void setConditionsType(String conditionsType) {
        this.conditionsType = conditionsType;
    }

    public SubSection getSubSection() {
        return subSection;
    }

    public void setSubSection(SubSection subSection) {
        this.subSection = subSection;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
