package com.azure.payload.qBank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoiceDTO {
    private String key;
    private String answer;
    private boolean isDefaultChoice;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isDefaultChoice() {
        return isDefaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        isDefaultChoice = defaultChoice;
    }
}