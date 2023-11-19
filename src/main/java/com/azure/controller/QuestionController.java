package com.azure.controller;

import com.azure.entity.qBank.Question;
import com.azure.payload.qBank.QuestionDTO;
import com.azure.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/save")
    public ResponseEntity<List<Question>> saveQuestions(@RequestBody List<QuestionDTO> questionDTO) {
        List<Question> questions = questionService.importQuestionBank(questionDTO);
        return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }
}