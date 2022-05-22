package sky.pro.Kyrs2.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.Kyrs2.exception.InvalidArgumentException;
import sky.pro.Kyrs2.data.Question;
import sky.pro.Kyrs2.services.QuestionService;
import sky.pro.Kyrs2.services.ExaminerService;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestion(int amount) {
       if (amount>questionService.size()||amount<=0){
           throw new InvalidArgumentException();
       }
        Collection<Question> getQuestion = new ArrayList<>();
        int i = 0;
        while (i < amount) {
            Question question = questionService.getRandomQuestion();
            if (i <1 || !getQuestion.contains(question)) {
                getQuestion.add(question);
                i++;
            }
        }
        System.out.println(getQuestion);
        return getQuestion;
    }
}
