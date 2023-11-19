package com.azure.service;


import com.azure.entity.qBank.Question;
import com.azure.entity.qBank.QuestionBank;
import com.azure.entity.qBank.QuestionBankQuestion;
import com.azure.mapper.QuestionMapper;
import com.azure.payload.qBank.QuestionBankDTO;
import com.azure.payload.qBank.QuestionDTO;
import com.azure.repository.qBank.QuestionBankQuestionRepo;
import com.azure.repository.qBank.QuestionBankRepo;
import com.azure.repository.qBank.QuestionRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionBankService {
    private static final Logger logger = Logger.getLogger(QuestionBankService.class);
    @Autowired
    private QuestionBankRepo questionBankRepo;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private QuestionBankQuestionRepo questionBankQuestionRepo;

    public QuestionBankDTO importQuestionBank(QuestionBankDTO questionBankDTO) {

        QuestionBank questionBank1 = new QuestionBank();
        questionBank1.setName(questionBankDTO.getName());
        questionBank1.setBankCode(questionBankDTO.getBankCode());
        questionBank1.setDescription(questionBankDTO.getDescription());
        questionBank1.setStatus(questionBankDTO.getStatus());
        QuestionBank savedQuestionBank = questionBankRepo.save(questionBank1);


        List<QuestionDTO> questionDTOS = questionBankDTO.getQuestionDTOS();
        List<Question> questionList = questionMapper.toEntityList(questionDTOS);
        List<Question> savedQuestions = questionRepo.saveAll(questionList);


       List<QuestionBankQuestion> questionBankQuestions = new ArrayList<>();

        for (Question question : savedQuestions){
            QuestionBankQuestion questionBankQuestion = new QuestionBankQuestion();
            questionBankQuestion.setQuestionBank(savedQuestionBank);

            questionBankQuestion.setQuestion(question);
            questionBankQuestions.add(questionBankQuestion);
        }
        questionBankQuestionRepo.saveAll(questionBankQuestions);

        return questionBankDTO;
    }

}