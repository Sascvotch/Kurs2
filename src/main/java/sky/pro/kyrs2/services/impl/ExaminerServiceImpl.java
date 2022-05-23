package sky.pro.kyrs2.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.kyrs2.exception.InvalidArgumentException;
import sky.pro.kyrs2.data.Question;
import sky.pro.kyrs2.services.QuestionService;
import sky.pro.kyrs2.services.ExaminerService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestion(Integer amount) {
        if (amount > questionService.size() || amount <= 0) {
            throw new InvalidArgumentException();
        }
        Collection<Question> getQuestion = new HashSet<>();
        while (getQuestion.size() < amount) {
            Question question = questionService.getRandomQuestion();
            getQuestion.add(question);
        }
        System.out.println(getQuestion);
        return getQuestion;
    }
}
