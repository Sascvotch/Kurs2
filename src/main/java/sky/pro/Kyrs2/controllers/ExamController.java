package sky.pro.Kyrs2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Kyrs2.services.ExaminerService;
import sky.pro.Kyrs2.data.Question;
import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public Collection<Question> getQuestion(@RequestParam("amount") int amount) {
        return examinerService.getQuestion(amount);
    }
}
