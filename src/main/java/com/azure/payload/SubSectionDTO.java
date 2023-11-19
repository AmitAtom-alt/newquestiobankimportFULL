package com.azure.payload;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubSectionDTO {
    private Long id;
    private String section;
    private String type;
    private String text;
    private String name;
    private List<ConditionsDTO> conditions;
    private List<QuestionSectionUserMappingDTO> questionSectionUserMapping;

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

    public List<ConditionsDTO> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionsDTO> conditions) {
        this.conditions = conditions;
    }

    public List<QuestionSectionUserMappingDTO> getQuestionSectionUserMapping() {
        return questionSectionUserMapping;
    }

    public void setQuestionSectionUserMapping(List<QuestionSectionUserMappingDTO> questionSectionUserMapping) {
        this.questionSectionUserMapping = questionSectionUserMapping;
    }
}