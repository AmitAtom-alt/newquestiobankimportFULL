package com.azure.service;

import com.azure.entity.Questionnaire;
import com.azure.entity.qBank.*;
import com.azure.payload.qBank.*;
import com.azure.repository.qBank.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
@Service
public class QuestionService {
    private static final Logger logger = Logger.getLogger(QuestionService.class);


    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public List<Question> importQuestionBank(List<QuestionDTO> questionDTO) {
        try {
            logger.info("Started importing question bank...");

            List<Question> questions = convertToEntity(questionDTO);
            List<Question> importedQuestions = questionRepository.saveAll(questions);
            logger.info("Imported {} questions successfully." + importedQuestions.size());
            return importedQuestions;
        } catch (Exception e) {
            logger.info("Error occurred while importing question bank", e);
            throw new RuntimeException("Error occurred while importing question bank: " + e.getMessage());
        }
    }

    private List<Question> convertToEntity(List<QuestionDTO> questionDTOList) {
        List<Question> questions = new ArrayList<>();

        for (QuestionDTO questionDTO : questionDTOList) {
            Question question = new Question();
            question.setCode(questionDTO.getCode());
            question.setName(questionDTO.getName());
            question.setLens(questionDTO.getLens());
            question.setCategory(questionDTO.getCategory());
            question.setSubCategory(questionDTO.getSubCategory());
            question.setQuestion(questionDTO.getQuestion());
            question.setStatement(questionDTO.getStatement());
            question.setContext(questionDTO.getContext());
            question.setQuestionDescription(questionDTO.getQuestionDescription());
            question.setColor(questionDTO.getColor());
            question.setTextFont(questionDTO.getTextFont());
            question.setType(questionDTO.getType());
            question.setDisabled(questionDTO.isDisabled());
            question.setWarn(questionDTO.getWarn());
            question.setWhy(questionDTO.getWhy());
            question.setSeverity(questionDTO.getSeverity());

            // Convert RecommendationDTO to Recommendation
            RecommendationDTO recommendationDTO = questionDTO.getRecommendation();
            if (recommendationDTO != null) {
                Recommendation recommendation = new Recommendation();
                recommendation.setTitle(recommendationDTO.getTitle());
                recommendation.setContext(recommendationDTO.getContext());
                recommendation.setPriority(recommendationDTO.getPriority());

                // Convert LinkDTO to Link and set in Recommendation
                List<LinkDTO> linkDTOs = recommendationDTO.getLinks();
                if (linkDTOs != null) {
                    List<Link> links = new ArrayList<>();
                    for (LinkDTO linkDTO : linkDTOs) {
                        Link link = new Link();
                        link.setTitle(linkDTO.getTitle());
                        link.setUrl(linkDTO.getUrl());
                        links.add(link);
                    }
                    recommendation.setLinks(links);
                }

                question.setRecommendation(recommendation);
            }

            List<QuestionConditionDTO> questionConditionDTOS = questionDTO.getQuestionConditions();
            if (questionConditionDTOS != null) {
                List<QuestionCondition> questionConditions = new ArrayList<>();
                for (QuestionConditionDTO questionConditionDTO : questionConditionDTOS) {
                    QuestionCondition questionCondition = new QuestionCondition();
                    questionCondition.setConditions(questionConditionDTO.getConditions());
                    questionCondition.setConditionsType(questionConditionDTO.getConditionsType());
                    questionCondition.setConditionsAnswer(questionConditionDTO.getConditionsAnswer());
                    questionConditions.add(questionCondition);
                }
                question.setQuestionConditions(questionConditions);
            }

            List<ChoiceDTO> choiceDTOs = questionDTO.getChoices();
            if (choiceDTOs != null) {
                List<Choice> choices = new ArrayList<>();
                for (ChoiceDTO choiceDTO : choiceDTOs) {
                    Choice choice = new Choice();
                    choice.setKey(choiceDTO.getKey());
                    choice.setAnswer(choiceDTO.getAnswer());
                    choice.setDefaultChoice(choiceDTO.isDefaultChoice());
                    choices.add(choice);
                }
                question.setChoices(choices);
            }
            List<QuestionValidationDTO> questionValidationDTOS = questionDTO.getQuestionValidation();
            if (questionValidationDTOS != null) {
                List<QuestionValidation> questionValidations = new ArrayList<>();
                for (QuestionValidationDTO questionValidationDTO : questionValidationDTOS) {
                    QuestionValidation questionValidation = new QuestionValidation();
                    questionValidation.setValidationRule(questionValidationDTO.getValidationRule());
                    questionValidations.add(questionValidation);
                }
                question.setQuestionValidation(questionValidations);
            }
            List<SubQuestionDTO> subQuestionDTOS = questionDTO.getSubQuestionsList();
            if (subQuestionDTOS != null) {
                List<SubQuestion> subQuestions = new ArrayList<>();
                for (SubQuestionDTO subQuestionDTO : subQuestionDTOS) {
                    SubQuestion subQuestion = new SubQuestion();
                    subQuestion.setCode(subQuestionDTO.getCode());
                    subQuestion.setName(subQuestionDTO.getName());
                    subQuestion.setQuestion(subQuestionDTO.getQuestion());
                    subQuestion.setStatement(subQuestionDTO.getStatement());
                    subQuestion.setContext(subQuestionDTO.getContext());


                    RecommendationDTO recommendationDTO2 = subQuestionDTO.getRecommendation();
                    if (recommendationDTO2 != null) {
                        Recommendation recommendation = new Recommendation();
                        recommendation.setTitle(recommendationDTO2.getTitle());
                        recommendation.setContext(recommendationDTO2.getContext());
                        recommendation.setPriority(recommendationDTO2.getPriority());

                        // Convert LinkDTO list to Link entity list (if applicable)
                        List<LinkDTO> linkDTOs = recommendationDTO2.getLinks();
                        if (linkDTOs != null) {
                            List<Link> links = new ArrayList<>();
                            for (LinkDTO linkDTO : linkDTOs) {
                                Link link = new Link();
                                link.setTitle(linkDTO.getTitle());
                                link.setUrl(linkDTO.getUrl());
                                links.add(link);
                            }
                            recommendation.setLinks(links);
                        }

                        subQuestion.setRecommendation(recommendation);
                    }
                    subQuestions.add(subQuestion);
                }
                question.setSubQuestionsList(subQuestions);
            }

            questions.add(question);
        }

        return questions;

    }
}

