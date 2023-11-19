package com.azure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "section")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String text;
    private String name;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
    @OneToMany(mappedBy = "sectionName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubSection> subSectionList;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<QuestionSectionUserMapping> questionSectionUserMapping;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conditions>  conditions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<SubSection> getSubSectionList() {
        return subSectionList;
    }

    public void setSubSectionList(List<SubSection> subSectionList) {
        this.subSectionList = subSectionList;
    }

    public List<QuestionSectionUserMapping> getQuestionSectionUserMapping() {
        return questionSectionUserMapping;
    }

    public void setQuestionSectionUserMapping(List<QuestionSectionUserMapping> questionSectionUserMapping) {
        this.questionSectionUserMapping = questionSectionUserMapping;
    }

    public List<Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(List<Conditions> conditions) {
        this.conditions = conditions;
    }
}