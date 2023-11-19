package com.azure.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionsDTO {

    private String conditions;
    private String conditionsAnswer;
    private String conditionsType;

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
}
