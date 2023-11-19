package com.azure.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireImportDTO {
    private String type;
    private String text;
    private String name;
    private List<SectionDTO> sectionQList;

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

    public List<SectionDTO> getSectionQList() {
        return sectionQList;
    }

    public void setSectionQList(List<SectionDTO> sectionQList) {
        this.sectionQList = sectionQList;
    }
}