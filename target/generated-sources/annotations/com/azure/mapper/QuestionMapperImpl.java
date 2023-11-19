package com.azure.mapper;

import com.azure.entity.qBank.Choice;
import com.azure.entity.qBank.Link;
import com.azure.entity.qBank.Question;
import com.azure.entity.qBank.QuestionCondition;
import com.azure.entity.qBank.QuestionValidation;
import com.azure.entity.qBank.Recommendation;
import com.azure.entity.qBank.SubQuestion;
import com.azure.payload.qBank.ChoiceDTO;
import com.azure.payload.qBank.LinkDTO;
import com.azure.payload.qBank.QuestionConditionDTO;
import com.azure.payload.qBank.QuestionDTO;
import com.azure.payload.qBank.QuestionValidationDTO;
import com.azure.payload.qBank.RecommendationDTO;
import com.azure.payload.qBank.SubQuestionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T18:13:37+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDTO toDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setCode( question.getCode() );
        questionDTO.setName( question.getName() );
        questionDTO.setLens( question.getLens() );
        questionDTO.setCategory( question.getCategory() );
        questionDTO.setSubCategory( question.getSubCategory() );
        questionDTO.setQuestion( question.getQuestion() );
        questionDTO.setStatement( question.getStatement() );
        questionDTO.setContext( question.getContext() );
        questionDTO.setRecommendation( recommendationToRecommendationDTO( question.getRecommendation() ) );
        questionDTO.setQuestionDescription( question.getQuestionDescription() );
        questionDTO.setQuestionConditions( questionConditionListToQuestionConditionDTOList( question.getQuestionConditions() ) );
        questionDTO.setColor( question.getColor() );
        questionDTO.setTextFont( question.getTextFont() );
        questionDTO.setType( question.getType() );
        questionDTO.setDisabled( question.isDisabled() );
        questionDTO.setChoices( choiceListToChoiceDTOList( question.getChoices() ) );
        questionDTO.setQuestionValidation( questionValidationListToQuestionValidationDTOList( question.getQuestionValidation() ) );
        questionDTO.setSubQuestionsList( subQuestionListToSubQuestionDTOList( question.getSubQuestionsList() ) );
        questionDTO.setWarn( question.getWarn() );
        questionDTO.setWhy( question.getWhy() );
        questionDTO.setSeverity( question.getSeverity() );

        return questionDTO;
    }

    @Override
    public List<QuestionDTO> toDtoList(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDTO> list = new ArrayList<QuestionDTO>( questions.size() );
        for ( Question question : questions ) {
            list.add( toDto( question ) );
        }

        return list;
    }

    @Override
    public Question toEntity(QuestionDTO questionDTO) {
        if ( questionDTO == null ) {
            return null;
        }

        Question question = new Question();

        question.setCode( questionDTO.getCode() );
        question.setName( questionDTO.getName() );
        question.setLens( questionDTO.getLens() );
        question.setCategory( questionDTO.getCategory() );
        question.setSubCategory( questionDTO.getSubCategory() );
        question.setQuestion( questionDTO.getQuestion() );
        question.setStatement( questionDTO.getStatement() );
        question.setContext( questionDTO.getContext() );
        question.setRecommendation( recommendationDTOToRecommendation( questionDTO.getRecommendation() ) );
        question.setQuestionDescription( questionDTO.getQuestionDescription() );
        question.setQuestionConditions( questionConditionDTOListToQuestionConditionList( questionDTO.getQuestionConditions() ) );
        question.setColor( questionDTO.getColor() );
        question.setTextFont( questionDTO.getTextFont() );
        question.setType( questionDTO.getType() );
        question.setDisabled( questionDTO.isDisabled() );
        question.setChoices( choiceDTOListToChoiceList( questionDTO.getChoices() ) );
        question.setQuestionValidation( questionValidationDTOListToQuestionValidationList( questionDTO.getQuestionValidation() ) );
        question.setSubQuestionsList( subQuestionDTOListToSubQuestionList( questionDTO.getSubQuestionsList() ) );
        question.setWarn( questionDTO.getWarn() );
        question.setWhy( questionDTO.getWhy() );
        question.setSeverity( questionDTO.getSeverity() );

        return question;
    }

    @Override
    public List<Question> toEntityList(List<QuestionDTO> questionDTOList) {
        if ( questionDTOList == null ) {
            return null;
        }

        List<Question> list = new ArrayList<Question>( questionDTOList.size() );
        for ( QuestionDTO questionDTO : questionDTOList ) {
            list.add( toEntity( questionDTO ) );
        }

        return list;
    }

    protected LinkDTO linkToLinkDTO(Link link) {
        if ( link == null ) {
            return null;
        }

        LinkDTO linkDTO = new LinkDTO();

        linkDTO.setTitle( link.getTitle() );
        linkDTO.setUrl( link.getUrl() );

        return linkDTO;
    }

    protected List<LinkDTO> linkListToLinkDTOList(List<Link> list) {
        if ( list == null ) {
            return null;
        }

        List<LinkDTO> list1 = new ArrayList<LinkDTO>( list.size() );
        for ( Link link : list ) {
            list1.add( linkToLinkDTO( link ) );
        }

        return list1;
    }

    protected RecommendationDTO recommendationToRecommendationDTO(Recommendation recommendation) {
        if ( recommendation == null ) {
            return null;
        }

        RecommendationDTO recommendationDTO = new RecommendationDTO();

        recommendationDTO.setTitle( recommendation.getTitle() );
        recommendationDTO.setContext( recommendation.getContext() );
        recommendationDTO.setLinks( linkListToLinkDTOList( recommendation.getLinks() ) );
        recommendationDTO.setPriority( recommendation.getPriority() );

        return recommendationDTO;
    }

    protected QuestionConditionDTO questionConditionToQuestionConditionDTO(QuestionCondition questionCondition) {
        if ( questionCondition == null ) {
            return null;
        }

        QuestionConditionDTO questionConditionDTO = new QuestionConditionDTO();

        questionConditionDTO.setConditions( questionCondition.getConditions() );
        questionConditionDTO.setConditionsAnswer( questionCondition.getConditionsAnswer() );
        questionConditionDTO.setConditionsType( questionCondition.getConditionsType() );

        return questionConditionDTO;
    }

    protected List<QuestionConditionDTO> questionConditionListToQuestionConditionDTOList(List<QuestionCondition> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionConditionDTO> list1 = new ArrayList<QuestionConditionDTO>( list.size() );
        for ( QuestionCondition questionCondition : list ) {
            list1.add( questionConditionToQuestionConditionDTO( questionCondition ) );
        }

        return list1;
    }

    protected ChoiceDTO choiceToChoiceDTO(Choice choice) {
        if ( choice == null ) {
            return null;
        }

        ChoiceDTO choiceDTO = new ChoiceDTO();

        choiceDTO.setKey( choice.getKey() );
        choiceDTO.setAnswer( choice.getAnswer() );
        choiceDTO.setDefaultChoice( choice.isDefaultChoice() );

        return choiceDTO;
    }

    protected List<ChoiceDTO> choiceListToChoiceDTOList(List<Choice> list) {
        if ( list == null ) {
            return null;
        }

        List<ChoiceDTO> list1 = new ArrayList<ChoiceDTO>( list.size() );
        for ( Choice choice : list ) {
            list1.add( choiceToChoiceDTO( choice ) );
        }

        return list1;
    }

    protected QuestionValidationDTO questionValidationToQuestionValidationDTO(QuestionValidation questionValidation) {
        if ( questionValidation == null ) {
            return null;
        }

        QuestionValidationDTO questionValidationDTO = new QuestionValidationDTO();

        questionValidationDTO.setValidationRule( questionValidation.getValidationRule() );

        return questionValidationDTO;
    }

    protected List<QuestionValidationDTO> questionValidationListToQuestionValidationDTOList(List<QuestionValidation> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionValidationDTO> list1 = new ArrayList<QuestionValidationDTO>( list.size() );
        for ( QuestionValidation questionValidation : list ) {
            list1.add( questionValidationToQuestionValidationDTO( questionValidation ) );
        }

        return list1;
    }

    protected SubQuestionDTO subQuestionToSubQuestionDTO(SubQuestion subQuestion) {
        if ( subQuestion == null ) {
            return null;
        }

        SubQuestionDTO subQuestionDTO = new SubQuestionDTO();

        subQuestionDTO.setCode( subQuestion.getCode() );
        subQuestionDTO.setName( subQuestion.getName() );
        subQuestionDTO.setQuestion( subQuestion.getQuestion() );
        subQuestionDTO.setStatement( subQuestion.getStatement() );
        subQuestionDTO.setContext( subQuestion.getContext() );
        subQuestionDTO.setRecommendation( recommendationToRecommendationDTO( subQuestion.getRecommendation() ) );

        return subQuestionDTO;
    }

    protected List<SubQuestionDTO> subQuestionListToSubQuestionDTOList(List<SubQuestion> list) {
        if ( list == null ) {
            return null;
        }

        List<SubQuestionDTO> list1 = new ArrayList<SubQuestionDTO>( list.size() );
        for ( SubQuestion subQuestion : list ) {
            list1.add( subQuestionToSubQuestionDTO( subQuestion ) );
        }

        return list1;
    }

    protected Link linkDTOToLink(LinkDTO linkDTO) {
        if ( linkDTO == null ) {
            return null;
        }

        Link link = new Link();

        link.setTitle( linkDTO.getTitle() );
        link.setUrl( linkDTO.getUrl() );

        return link;
    }

    protected List<Link> linkDTOListToLinkList(List<LinkDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Link> list1 = new ArrayList<Link>( list.size() );
        for ( LinkDTO linkDTO : list ) {
            list1.add( linkDTOToLink( linkDTO ) );
        }

        return list1;
    }

    protected Recommendation recommendationDTOToRecommendation(RecommendationDTO recommendationDTO) {
        if ( recommendationDTO == null ) {
            return null;
        }

        Recommendation recommendation = new Recommendation();

        recommendation.setTitle( recommendationDTO.getTitle() );
        recommendation.setContext( recommendationDTO.getContext() );
        recommendation.setLinks( linkDTOListToLinkList( recommendationDTO.getLinks() ) );
        recommendation.setPriority( recommendationDTO.getPriority() );

        return recommendation;
    }

    protected QuestionCondition questionConditionDTOToQuestionCondition(QuestionConditionDTO questionConditionDTO) {
        if ( questionConditionDTO == null ) {
            return null;
        }

        QuestionCondition questionCondition = new QuestionCondition();

        questionCondition.setConditions( questionConditionDTO.getConditions() );
        questionCondition.setConditionsAnswer( questionConditionDTO.getConditionsAnswer() );
        questionCondition.setConditionsType( questionConditionDTO.getConditionsType() );

        return questionCondition;
    }

    protected List<QuestionCondition> questionConditionDTOListToQuestionConditionList(List<QuestionConditionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionCondition> list1 = new ArrayList<QuestionCondition>( list.size() );
        for ( QuestionConditionDTO questionConditionDTO : list ) {
            list1.add( questionConditionDTOToQuestionCondition( questionConditionDTO ) );
        }

        return list1;
    }

    protected Choice choiceDTOToChoice(ChoiceDTO choiceDTO) {
        if ( choiceDTO == null ) {
            return null;
        }

        Choice choice = new Choice();

        choice.setKey( choiceDTO.getKey() );
        choice.setAnswer( choiceDTO.getAnswer() );
        choice.setDefaultChoice( choiceDTO.isDefaultChoice() );

        return choice;
    }

    protected List<Choice> choiceDTOListToChoiceList(List<ChoiceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Choice> list1 = new ArrayList<Choice>( list.size() );
        for ( ChoiceDTO choiceDTO : list ) {
            list1.add( choiceDTOToChoice( choiceDTO ) );
        }

        return list1;
    }

    protected QuestionValidation questionValidationDTOToQuestionValidation(QuestionValidationDTO questionValidationDTO) {
        if ( questionValidationDTO == null ) {
            return null;
        }

        QuestionValidation questionValidation = new QuestionValidation();

        questionValidation.setValidationRule( questionValidationDTO.getValidationRule() );

        return questionValidation;
    }

    protected List<QuestionValidation> questionValidationDTOListToQuestionValidationList(List<QuestionValidationDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionValidation> list1 = new ArrayList<QuestionValidation>( list.size() );
        for ( QuestionValidationDTO questionValidationDTO : list ) {
            list1.add( questionValidationDTOToQuestionValidation( questionValidationDTO ) );
        }

        return list1;
    }

    protected SubQuestion subQuestionDTOToSubQuestion(SubQuestionDTO subQuestionDTO) {
        if ( subQuestionDTO == null ) {
            return null;
        }

        SubQuestion subQuestion = new SubQuestion();

        subQuestion.setCode( subQuestionDTO.getCode() );
        subQuestion.setName( subQuestionDTO.getName() );
        subQuestion.setQuestion( subQuestionDTO.getQuestion() );
        subQuestion.setStatement( subQuestionDTO.getStatement() );
        subQuestion.setContext( subQuestionDTO.getContext() );
        subQuestion.setRecommendation( recommendationDTOToRecommendation( subQuestionDTO.getRecommendation() ) );

        return subQuestion;
    }

    protected List<SubQuestion> subQuestionDTOListToSubQuestionList(List<SubQuestionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SubQuestion> list1 = new ArrayList<SubQuestion>( list.size() );
        for ( SubQuestionDTO subQuestionDTO : list ) {
            list1.add( subQuestionDTOToSubQuestion( subQuestionDTO ) );
        }

        return list1;
    }
}
