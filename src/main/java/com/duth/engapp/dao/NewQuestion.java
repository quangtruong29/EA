package com.duth.engapp.dao;

import com.duth.engapp.entity.Question;
import com.duth.engapp.entity.TypesOfQuestion;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NewQuestion implements Serializable {
    private Long id;
    @NotNull
    @NotBlank
    private String questcontent;
    @NotNull
    @NotBlank
    private String a;
    @NotNull
    @NotBlank
    private String b;
    @NotNull
    @NotBlank
    private String c;
    @NotNull
    @NotBlank
    private String d;
    @NotNull
    @NotBlank
    private String answer;
    private String image;
    @NotNull
    private int typeid;
    public Question toQuestion()
    {
        return new Question(id, questcontent, a, b, c, d, answer, image, TypesOfQuestion.builder().id(typeid).build());
    }

}