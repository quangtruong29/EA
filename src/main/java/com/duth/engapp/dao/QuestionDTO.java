package com.duth.engapp.dao;

import com.duth.engapp.entity.Question;
import com.duth.engapp.entity.SetsOfQuestion;
import com.duth.engapp.entity.TypesOfQuestion;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String questcontent;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;
    private String image;
    private SetsOfQuestion setid;
    private TypesOfQuestion typeid;
    public QuestionDTO(Question question)
    {
        this.id = question.getId();
        this.questcontent = question.getQuestcontent();
        this.a = question.getA();
        this.b = question.getB();
        this.c = question.getC();
        this.d = question.getD();
        this.answer = question.getAnswer();
        this.image = question.getImage();
        this.typeid = question.getTypeid();
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", questcontent='" + questcontent + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", answer='" + answer + '\'' +
                ", image='" + image + '\'' +
                ", setid=" + setid +
                ", typeid=" + typeid +
                '}';
    }
}
