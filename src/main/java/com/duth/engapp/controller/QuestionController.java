package com.duth.engapp.controller;

import com.duth.engapp.dao.NewQuestion;
import com.duth.engapp.dao.QuestionDTO;
import com.duth.engapp.entity.Question;
import com.duth.engapp.payload.ApiResponse;
import com.duth.engapp.repository.QuestionRepository;
import com.duth.engapp.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController extends RootController {
    QuestionRepository questionRepository;
    QuestionService questionService;
    Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    public QuestionController(QuestionRepository questionRepository, QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    @GetMapping("/all")
    ApiResponse all() {
        ApiResponse response = new ApiResponse(200, "Get question success",null );
        List<Question> questions = questionRepository.findAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question q: questions) {
            questionDTOS.add(new QuestionDTO(q));
            logger.info((new QuestionDTO(q).toString()));
        }
        response.setResult(questionDTOS);
        return response;
    }
    @PostMapping("/update")
    ApiResponse save(@Valid @RequestBody NewQuestion question) {
        ApiResponse response = new ApiResponse(200, "Insert success",null );
        Question question1 = question.toQuestion();
        if(question.getId() != null)
        {
            Optional<Question>  question2  = questionRepository.findById(question.getId());
            if(question2.isPresent())
            {
                response.setMessage("Update success");
            }
        }
        try{
            question1 = questionRepository.save(question1);
            response.setResult(question1);
        }catch (Exception ex)
        {
            response.setStatus(500);
            response.setMessage("Update failed");
            ex.printStackTrace();
        }
        return response;
    }

    @GetMapping("/random")
    ApiResponse random() {
        ApiResponse response = new ApiResponse(200, "Get random question success",null );
        List<Question> questions = questionService.getRandom();
        response.setResult(questions);
        return response;
    }
}
