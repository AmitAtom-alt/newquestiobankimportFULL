package com.azure.entity.qBank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Entity
public class QuestionCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "conditions")
    private String conditions;
    @Column(length = 65555)
    private String conditionsAnswer;
    @Column(name = "conditionsType")
    private String conditionsType;

    @ManyToOne
    @JoinColumn(name = "question_code", referencedColumnName = "code")
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    //    public void setConditionsAnswer(String conditionsAnswer) {
//        // Trim the conditionsAnswer before setting it
//        if (conditionsAnswer != null) {
//            this.conditionsAnswer = conditionsAnswer.substring(0, Math.min(conditionsAnswer.length(), 255));
//        } else {
//            this.conditionsAnswer = conditionsAnswer;
//        }
//    }
}
