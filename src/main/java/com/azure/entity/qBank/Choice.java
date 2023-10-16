package com.azure.entity.qBank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`key'")
    private String key;
    @Column(length = 2000)
    private String answer;
    private boolean isDefaultChoice = false;


    @ManyToOne
    @JoinColumn(name = "question_code", referencedColumnName = "code")
    private Question question;
}