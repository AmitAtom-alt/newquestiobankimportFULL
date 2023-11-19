package com.azure.entity.qBank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class QuestionCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "conditions")
    private String conditions;
    @Column(name = "conditionsAnswer")
    private String conditionsAnswer;
    @Column(name = "conditionsType")
    private String conditionsType;

    @ManyToOne
    @JoinColumn(name = "question_code", referencedColumnName = "code")
    private Question question;


//    public void setConditionsAnswer(String conditionsAnswer) {
//        // Trim the conditionsAnswer before setting it
//        if (conditionsAnswer != null) {
//            this.conditionsAnswer = conditionsAnswer.substring(0, Math.min(conditionsAnswer.length(), 255));
//        } else {
//            this.conditionsAnswer = conditionsAnswer;
//        }
//    }
}
