package com.azure.service;

import com.azure.entity.*;
import com.azure.entity.qBank.Question;
import com.azure.exception.QuestionnaireException;
import com.azure.exception.ResourceNotFoundException;
import com.azure.payload.*;
import com.azure.repository.QuestionSectionUserMappingRepository;
import com.azure.repository.QuestionnaireRepository;
import com.azure.repository.SectionRepository;
import com.azure.repository.qBank.QuestionRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {
    private static final Logger logger = Logger.getLogger(QuestionnaireService.class);

    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionSectionUserMappingRepository questionSectionUserMappingRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @Transactional
    public Questionnaire saveQuestionnaire(QuestionnaireImportDTO questionnaireImportDTO) {
        Questionnaire existingQuestionnaire = questionnaireRepository.findByName(questionnaireImportDTO.getName());
        if (existingQuestionnaire != null){
            throw new QuestionnaireException("Questionnaire with name: "+questionnaireImportDTO.getName()+" already exists");
        }

        logger.info("Entity conversion started");
        Questionnaire questionnaire = convertToEntity(questionnaireImportDTO);
        Questionnaire saved = questionnaireRepository.save(questionnaire);
        return saved;
    }
    public Questionnaire convertToEntity(QuestionnaireImportDTO questionnaireImportDTO) {
        // logger.info("Questionnaire Entity conversion started");
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(questionnaireImportDTO.getName());
        questionnaire.setType(questionnaireImportDTO.getType());
        questionnaire.setText(questionnaireImportDTO.getText());
        // Convert SectionDTO to Section and set it in Questionnaire entity
        List<Section> sections = questionnaireImportDTO.getSectionQList().stream()
                .map(this::convertToSection)
                .collect(Collectors.toList());

        questionnaire.setSectionQList(sections);

        return questionnaire;
    }


    private Section convertToSection(SectionDTO sectionDTO) {
        //logger.info("Section Entity conversion started");
        Section section = new Section();
        section.setType(sectionDTO.getType());
        section.setText(sectionDTO.getText());
        section.setName(sectionDTO.getName());

        // Convert SubSectionDTO to SubSection and set it in Section entity
        List<SubSection> subSections = sectionDTO.getSubSectionList() != null ?
                sectionDTO.getSubSectionList().stream()
                .map(this::convertToSubSection)
                .collect(Collectors.toList()) :
                Collections.emptyList();
        section.setSubSectionList(subSections);

        // Convert QuestionSectionUserMappingDTO to QuestionSectionUserMapping and set it in SubSection entity
        List<QuestionSectionUserMapping> mappings = sectionDTO.getQuestionSectionUserMapping() != null ?
                sectionDTO.getQuestionSectionUserMapping().stream()
                                .map(this::convertToQuestionSectionUserMappings)
                                        .collect(Collectors.toList()) :
                Collections.emptyList();
        section.setQuestionSectionUserMapping(mappings);

        List<Conditions> mappings2 = sectionDTO.getConditions()!= null ?
                sectionDTO.getConditions()
                        .stream()
                        .map(this::convertToConditions)
                        .collect(Collectors.toList()) :
                Collections.emptyList();

        section.setConditions(mappings2);


        return section;
    }

    private SubSection convertToSubSection(SubSectionDTO subSectionDTO) {
       // logger.info("Sub Section Entity conversion started");

        SubSection subSection = new SubSection();
        subSection.setSection(subSectionDTO.getSection());
        subSection.setType(subSectionDTO.getType());
        subSection.setText(subSectionDTO.getText());
        subSection.setName(subSectionDTO.getName());
        // Convert QuestionSectionUserMappingDTO to QuestionSectionUserMapping and set it in SubSection entity
        List<QuestionSectionUserMapping> mappings = subSectionDTO.getQuestionSectionUserMapping() != null ?
                subSectionDTO.getQuestionSectionUserMapping().stream()
                                .map(this::convertToQuestionSectionUserMappings)
                                        .collect(Collectors.toList()) :
                Collections.emptyList();
        subSection.setQuestionSectionUserMapping(mappings);
        List<Conditions> mappings2 = subSectionDTO.getConditions()!= null ?
                subSectionDTO.getConditions()
                .stream()
                .map(this::convertToConditions)
                .collect(Collectors.toList()) :
                Collections.emptyList();
        subSection.setConditions(mappings2);

        return subSection;
    }

    private QuestionSectionUserMapping convertToQuestionSectionUserMappings(QuestionSectionUserMappingDTO mappingDTOs)  {
        logger.info("QuestionSectionUserMapping Entity conversion started");
        //mappingDTOs.forEach(mappingDTO -> logger.info("Question Code: " + mappingDTO.getQuestionCode()));
        //load object based on question code
        String questionCode1 = mappingDTOs.getQuestionCode();
        logger.info("Processing Question Code: "+questionCode1);

        Question questionRepositoryByCode = questionRepository.findByCode(questionCode1);
        if (questionRepositoryByCode == null){
            logger.error("Question not found for code: "+questionCode1);
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND," question code not found");

        }
        QuestionSectionUserMapping questionSectionUserMapping = new QuestionSectionUserMapping();
        questionSectionUserMapping.setQuestion(questionRepositoryByCode);
        questionSectionUserMapping.setIndex(mappingDTOs.getIndex());
        //
        logger.info("Mapped Question: " + questionCode1 + " to QuestionSectionUserMapping with id " + questionSectionUserMapping.getId());
        //
        return questionSectionUserMapping;

    }
    private Conditions convertToConditions(ConditionsDTO conditionsDTO){
       // logger.info("Conditions Entity conversion started");
        Conditions conditions = new Conditions();
        conditions.setConditions(conditionsDTO.getConditions());
        conditions.setConditionsType(conditionsDTO.getConditionsType());
        conditions.setConditionsAnswer(conditionsDTO.getConditionsAnswer());
        return conditions;
    }



}
