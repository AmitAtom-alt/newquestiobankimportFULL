package com.azure.controller;


import com.azure.entity.Questionnaire;
import com.azure.entity.qBank.QuestionBank;
import com.azure.exception.QuestionnaireException;
import com.azure.payload.qBank.QuestionBankDTO;
import com.azure.repository.qBank.QuestionBankRepo;
import com.azure.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;
    @Autowired
    private QuestionBankRepo questionBankRepo;

    @PostMapping("/import")
    public ResponseEntity<QuestionBankDTO> importQuestionBank(@RequestBody QuestionBankDTO questionBankDTO){

        QuestionBank existingQuestionBank = questionBankRepo.findByBankCode(questionBankDTO.getBankCode());
        if (existingQuestionBank != null){
            throw new QuestionnaireException("QB with name: "+questionBankDTO.getBankCode()+" already exists");
        }
        String questionBankCode = questionBankService.importQuestionBank(questionBankDTO);
        return new ResponseEntity<>(questionBankDTO, HttpStatus.CREATED);

    }
}
