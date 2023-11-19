package com.azure.entity;

import com.azure.entity.qBank.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questionSectionUserMapping")
public class QuestionSectionUserMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Question class
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @Column(name = "`index`")
    private int index;
    @ManyToOne
    @JoinColumn(name = "sub_section_id")
    private SubSection subSection;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public SubSection getSubSection() {
        return subSection;
    }

    public void setSubSection(SubSection subSection) {
        this.subSection = subSection;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}