package com.azure.service;


import com.azure.entity.qBank.Question;
import com.azure.entity.qBank.QuestionBank;
import com.azure.entity.qBank.QuestionBankQuestion;
import com.azure.exception.QuestionnaireException;
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

    private void updateOrCreateQuestions(List<Question> questionList) {
        for (Question question : questionList) {
            Question existingQuestion = questionRepo.findByCode(question.getCode());
            if (existingQuestion != null) {
                // Update existing question's details
                existingQuestion.setName(question.getName());
                // Update other fields as needed
                questionRepo.save(existingQuestion); // Save the updated question
            } else {
                // If the question doesn't exist, save it as a new question
                questionRepo.save(question);
            }
        }
    }

    private void associateQuestionsWithBank(QuestionBank questionBank, List<Question> questionList) {
        for (Question question : questionList) {
            if (question.getId() != null && questionBank.getId() != null) {
                QuestionBankQuestion questionBankQuestion = new QuestionBankQuestion();
                questionBankQuestion.setQuestionBank(questionBank);
                questionBankQuestion.setQuestion(question);
                questionBankQuestionRepo.save(questionBankQuestion);
            } else {
                throw new QuestionnaireException("exception from associate");
                // Log or handle cases where either question or questionBank is null
                // This prevents saving a QuestionBankQuestion with null references
            }
        }
    }

    private QuestionBank mapQuestionBankToQuestion(QuestionBank questionBank1, QuestionBankDTO questionBankDTO) {
        List<QuestionDTO> questionDTOS = questionBankDTO.getQuestionDTOS();
        List<Question> questionList = questionMapper.toEntityList(questionDTOS);

        updateOrCreateQuestions(questionList); // Update or save new questions
        associateQuestionsWithBank(questionBank1, questionList); // Associate questions with the bank

        return questionBank1;
    }

    public String importQuestionBank(QuestionBankDTO questionBankDTO) {
        logger.info("Processing import importQuestionBank");

        QuestionBank questionBank1 = new QuestionBank();
        questionBank1.setName(questionBankDTO.getName());
        questionBank1.setBankCode(questionBankDTO.getBankCode());
        questionBank1.setDescription(questionBankDTO.getDescription());
        questionBank1.setStatus(questionBankDTO.getStatus());

        QuestionBank questionBank = mapQuestionBankToQuestion(questionBank1, questionBankDTO);

        QuestionBank savedQuestionBank = questionBankRepo.save(questionBank);
        logger.info("questionbank saved to repo");
        return savedQuestionBank.getBankCode();
    }


//    public String importQuestionBank(QuestionBankDTO questionBankDTO) {
//        logger.info("Processing import importQuestionBank  ");
//
//        QuestionBank questionBank1 = new QuestionBank();
//        questionBank1.setName(questionBankDTO.getName());
//        questionBank1.setBankCode(questionBankDTO.getBankCode());
//        questionBank1.setDescription(questionBankDTO.getDescription());
//        questionBank1.setStatus(questionBankDTO.getStatus());
//
//        QuestionBank questionBank= mapQuestionBankToQuestion(questionBank1, questionBankDTO);
//
//
//        QuestionBank savedQuestionBank = questionBankRepo.save(questionBank);
//        logger.info("questionbank saved to repo  ");
//        return savedQuestionBank.getBankCode();
//
//    }
//
//    private QuestionBank mapQuestionBankToQuestion(QuestionBank questionBank1, QuestionBankDTO questionBankDTO) {
//
//
//        List<QuestionDTO> questionDTOS = questionBankDTO.getQuestionDTOS();
//        List<Question> questionList = questionMapper.toEntityList(questionDTOS);
//
//
//        List<Question> savedQuestions = questionRepo.saveAll(questionList);
//        logger.info("List<Question> saved ");
//        List<QuestionBankQuestion> questionBankQuestions = new ArrayList<>();
//
//
//        for (Question question : questionList){
//            Question existingQuestion = questionRepo.findByCode(question.getCode());
//            if (existingQuestion != null){
//                existingQuestion.setName(question.getName());
//                questionRepo.save(existingQuestion);
//            }else{
//                questionRepo.save(question);
//            }
//            QuestionBankQuestion questionBankQuestion = new QuestionBankQuestion();
//            questionBankQuestion.setQuestionBank(questionBank1);
//            logger.info("setQuestionBank for  questionBankQuestion ");
//
//            questionBankQuestion.setQuestion(question);
//            logger.info("setQuestion for  questionBankQuestion ");
//            questionBankQuestions.add(questionBankQuestion);
//            logger.info("questionBankQuestion questionBankQuestion for  questionBankQuestion ");
//        }
//        questionBankQuestionRepo.saveAll(questionBankQuestions);
//        logger.info("questionBankQuestionRepo.saveAll(questionBankQuestions); saved ");
//
//        return questionBank1;
//
//    }

}