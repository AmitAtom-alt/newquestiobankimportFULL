package com.azure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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


}