package com.azure.controller;


import com.azure.payload.qBank.QuestionBankDTO;
import com.azure.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @PostMapping("/import")
    public ResponseEntity<QuestionBankDTO> importQuestionBank(@RequestBody QuestionBankDTO questionBankDTO){

        QuestionBankDTO questionBankDTO1 = questionBankService.importQuestionBank(questionBankDTO);
        return new ResponseEntity<>(questionBankDTO, HttpStatus.CREATED);

    }
}
