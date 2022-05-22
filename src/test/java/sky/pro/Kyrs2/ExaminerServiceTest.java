package sky.pro.Kyrs2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.Kyrs2.data.Question;
import sky.pro.Kyrs2.services.impl.ExaminerServiceImpl;
import sky.pro.Kyrs2.services.impl.JavaQuestionService;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    private final Collection<Question> questionList = new ArrayList<>(Arrays.asList(
            new Question("Вопрос2", "Ответ2")
    ));
    private final Question question = new Question("Вопрос2", "Ответ2");
    private final int amount = 1;

    @Test
    public void getQuestionTest() {
        int amount = 1;
        when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        when(javaQuestionService.size()).thenReturn(1);
        Collection<Question> expected = questionList;
        Collection<Question> actual = out.getQuestion(amount);
        assertEquals(expected, actual);

    }

}
