package com.azure.payload;
import com.azure.entity.Section;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionDTO {
    private Long id;
    private String type;
    private String text;
    private String name;
    private List<SubSectionDTO> subSectionList;
    private List<ConditionsDTO> conditions;
    private List<QuestionSectionUserMappingDTO> questionSectionUserMapping;

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

    public List<SubSectionDTO> getSubSectionList() {
        return subSectionList;
    }

    public void setSubSectionList(List<SubSectionDTO> subSectionList) {
        this.subSectionList = subSectionList;
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

