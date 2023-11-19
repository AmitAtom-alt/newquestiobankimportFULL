package com.azure.repository.qBank;


import com.azure.entity.qBank.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionBankRepo extends JpaRepository<QuestionBank, Long> {
    @Query("SELECT qb FROM QuestionBank qb WHERE qb.bankCode = :bankCode")
    QuestionBank findByBankCode(@Param("bankCode") String bankCode);
}
