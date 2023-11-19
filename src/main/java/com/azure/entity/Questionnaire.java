package com.azure.entity;

import com.azure.payload.SectionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String text;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    private List<Section> sectionQList;

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

    public List<Section> getSectionQList() {
        return sectionQList;
    }

    public void setSectionQList(List<Section> sectionQList) {
        this.sectionQList = sectionQList;
    }
}