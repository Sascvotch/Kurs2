package sky.pro.kyrs2.controllers;

import org.springframework.web.bind.annotation.*;
import sky.pro.kyrs2.services.ExaminerService;
import sky.pro.kyrs2.data.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestion(amount);
    }
}
