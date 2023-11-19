package com.azure.mapper;

import com.azure.entity.qBank.Question;
import com.azure.payload.qBank.QuestionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toDto(Question question);
    List<QuestionDTO> toDtoList(List<Question> questions);
    Question toEntity(QuestionDTO questionDTO);
    List<Question> toEntityList(List<QuestionDTO> questionDTOList);

}
