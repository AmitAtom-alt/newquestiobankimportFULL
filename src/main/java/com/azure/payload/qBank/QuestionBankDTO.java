package com.azure.payload.qBank;

import java.util.List;

public class QuestionBankDTO {
    private Long id;
    private String name;

    private String bankCode;
    private String description;
    private String status;
    private List<QuestionDTO> questionDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuestionDTO> getQuestionDTOS() {
        return questionDTOS;
    }

    public void setQuestionDTOS(List<QuestionDTO> questionDTOS) {
        this.questionDTOS = questionDTOS;
    }
}
