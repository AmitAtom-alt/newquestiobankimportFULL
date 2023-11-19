package com.azure.payload.qBank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Lob;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {
    private String code;
    private String name;
    private String lens;
    private String category;
    private String subCategory;
    private String question;
    private String statement;

    private String context;
    private RecommendationDTO recommendation;
    private String questionDescription;
    private List<QuestionConditionDTO> questionConditions;
    private String color;
    private String textFont;
    private String type;
    private boolean disabled;
    private List<ChoiceDTO> choices;
    private List<QuestionValidationDTO> questionValidation;
    private List<SubQuestionDTO> subQuestionsList;


    private String warn;
    private String why;
    private String severity;

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

    public RecommendationDTO getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(RecommendationDTO recommendation) {
        this.recommendation = recommendation;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public List<QuestionConditionDTO> getQuestionConditions() {
        return questionConditions;
    }

    public void setQuestionConditions(List<QuestionConditionDTO> questionConditions) {
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

    public List<ChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceDTO> choices) {
        this.choices = choices;
    }

    public List<QuestionValidationDTO> getQuestionValidation() {
        return questionValidation;
    }

    public void setQuestionValidation(List<QuestionValidationDTO> questionValidation) {
        this.questionValidation = questionValidation;
    }

    public List<SubQuestionDTO> getSubQuestionsList() {
        return subQuestionsList;
    }

    public void setSubQuestionsList(List<SubQuestionDTO> subQuestionsList) {
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