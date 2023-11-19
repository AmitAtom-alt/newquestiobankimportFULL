package com.azure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_section")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String section;
    private String type;
    private String text;
    private String name;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section sectionName;

    @OneToMany(mappedBy = "subSection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionSectionUserMapping> questionSectionUserMapping;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_section_id")
    private List<Conditions>  conditions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public Section getSectionName() {
        return sectionName;
    }

    public void setSectionName(Section sectionName) {
        this.sectionName = sectionName;
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