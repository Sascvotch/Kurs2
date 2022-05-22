package sky.pro.Kyrs2.services;

import org.springframework.stereotype.Service;
import sky.pro.Kyrs2.services.impl.JavaQuestionService;
import sky.pro.Kyrs2.data.Question;

import java.util.Collection;

@Service
public interface QuestionService {

    Question add(String question, String answer) throws JavaQuestionService.MyException;

    Question add(Question question) throws JavaQuestionService.MyException;

    Question remove(Question question) throws JavaQuestionService.MyException;

    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();
}
