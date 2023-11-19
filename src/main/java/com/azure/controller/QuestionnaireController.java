package com.azure.controller;

import com.azure.entity.Questionnaire;
import com.azure.exception.QuestionnaireException;
import com.azure.exception.ResourceNotFoundException;
import com.azure.payload.QuestionnaireImportDTO;
import com.azure.service.QuestionnaireService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/import")
    public ResponseEntity<?> importQuestionnaire(@RequestBody QuestionnaireImportDTO questionnaireImportDTOS) {
        try{
        Questionnaire questionnaire = questionnaireService.saveQuestionnaire(questionnaireImportDTOS);
        return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
    }catch (QuestionnaireException q){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(q.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while importing questionnaire data.");
        }
        }
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Questionnaire>> getAllQuestionnaire(){
//        List<Questionnaire> all = questionnaireService.getAll();
//        return ResponseEntity.ok(all);
//    }

}
