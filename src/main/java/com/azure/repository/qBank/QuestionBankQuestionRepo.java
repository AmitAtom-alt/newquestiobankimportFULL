package com.azure.repository.qBank;


import com.azure.entity.qBank.QuestionBankQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionBankQuestionRepo extends JpaRepository<QuestionBankQuestion, Long> {

}
