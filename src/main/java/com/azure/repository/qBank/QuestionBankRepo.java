package com.azure.repository.qBank;


import com.azure.entity.qBank.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBankRepo extends JpaRepository<QuestionBank, Long> {
}
