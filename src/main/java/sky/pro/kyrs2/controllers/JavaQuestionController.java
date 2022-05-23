package sky.pro.kyrs2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.kyrs2.services.impl.JavaQuestionService;
import sky.pro.kyrs2.data.Question;
import sky.pro.kyrs2.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")

public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/java/add")
    public Question questionAdd(@RequestParam("quest") String question, @RequestParam("ans") String answer) {
        return questionService.add(new Question(question, answer));
    }

    @GetMapping(path = "/java")
    public Collection<Question> questionGetAll() {
        return questionService.getAll();
    }

    @GetMapping(path = "/java/remove")
    public Question questionRemove(@RequestParam("quest") String question, @RequestParam("ans") String answer) {
        return questionService.remove(new Question(question, answer));
    }

}
