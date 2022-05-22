package sky.pro.kyrs2.services;

import org.springframework.stereotype.Service;
import sky.pro.kyrs2.services.impl.JavaQuestionService;
import sky.pro.kyrs2.data.Question;

import java.util.Collection;

@Service
public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();
}
