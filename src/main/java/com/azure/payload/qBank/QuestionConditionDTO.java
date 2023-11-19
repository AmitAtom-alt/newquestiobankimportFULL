package com.azure.payload.qBank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionConditionDTO {
    private String conditions;

    private String conditionsAnswer;
    private String conditionsType;
}