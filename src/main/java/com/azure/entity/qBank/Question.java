package com.azure.entity.qBank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    private String lens;
    private String category;
    private String subCategory;
    @Column(length = 2000)
    private String question;
    private String statement;
    @Column(length = 65555)
    private String context;
    @OneToOne(cascade = CascadeType.ALL)
    private Recommendation recommendation;
    private String questionDescription;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<QuestionCondition> questionConditions;

    private String color;
    private String textFont;
    private String type;
    private boolean disabled = false;


    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Choice> choices;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_code")
    private List<QuestionValidation> questionValidation;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<SubQuestion> subQuestionsList;

    private String warn;
    @Column(length = 65555)
    private String why;
    private String severity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public List<QuestionCondition> getQuestionConditions() {
        return questionConditions;
    }

    public void setQuestionConditions(List<QuestionCondition> questionConditions) {
        this.questionConditions = questionConditions;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextFont() {
        return textFont;
    }

    public void setTextFont(String textFont) {
        this.textFont = textFont;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<QuestionValidation> getQuestionValidation() {
        return questionValidation;
    }

    public void setQuestionValidation(List<QuestionValidation> questionValidation) {
        this.questionValidation = questionValidation;
    }

    public List<SubQuestion> getSubQuestionsList() {
        return subQuestionsList;
    }

    public void setSubQuestionsList(List<SubQuestion> subQuestionsList) {
        this.subQuestionsList = subQuestionsList;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}