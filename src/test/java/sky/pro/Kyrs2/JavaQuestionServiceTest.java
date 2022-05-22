package sky.pro.Kyrs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.Kyrs2.data.Question;
import sky.pro.Kyrs2.services.impl.JavaQuestionService;
import java.util.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class JavaQuestionServiceTest {

    private JavaQuestionService out = new JavaQuestionService();
    private final Map<String, Question> questionMap = new HashMap<>(Map.of(
            "Вопрос1Ответ1", new Question("Вопрос1", "Ответ1"),
            "Вопрос2Ответ2", new Question("Вопрос2", "Ответ2")
    ));

    public static Stream<Arguments> provideParamsForAddTest() {
        return Stream.of(
                Arguments.of("Вопрос8", "Ответ8"),
                Arguments.of("Вопрос9", "Ответ9")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddTest")
    public void addTest(String question, String answer) throws JavaQuestionService.MyException {
        Question expected = new Question(question, answer);
        Question actual = out.add(question, answer);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideParamsForQuestionTest() {
        return Stream.of(
                Arguments.of(new Question("Вопрос8", "Ответ8")),
                Arguments.of(new Question("Вопрос9", "Ответ9"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForQuestionTest")
    public void findTest(Question question) throws JavaQuestionService.MyException {
        Question expected = out.add(question);
        Question actual = out.find(question);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForQuestionTest")
    public void removeTest(Question question) throws JavaQuestionService.MyException {
        out.add(question);
        out.remove(question);
        Assertions.assertThrows(JavaQuestionService.MyException.class, () -> out.find(question));
    }

    @Test
    public void getAllTest() throws JavaQuestionService.MyException {
        out.removeAll();
        Collection<Question> expected = new ArrayList<Question>(Arrays.asList(new Question("Вопрос10", "Ответ10"),
                new Question("Вопрос20", "Ответ20")));
        out.add("Вопрос10", "Ответ10");
        out.add("Вопрос20", "Ответ20");
        assertEquals(expected, out.getAll());

    }

    public static Stream<Arguments> provideParamsForemployeeAlreadyExistsTest() {
        Question currentQuestion = new Question("Вопрос1", "Ответ1");
        Map<String, Question> questionMap = new HashMap<>(Map.of(
                "Вопрос1Ответ1", currentQuestion
        ));
        return Stream.of(Arguments.of(questionMap, currentQuestion));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForemployeeAlreadyExistsTest")
    public void employeeAlreadyExistsTest(Map<String, Question> questionMap, Question currentQuestion) throws JavaQuestionService.MyException {
        assertThrows(RuntimeException.class,
                () -> out.EmployeeAlreadyExists(questionMap, currentQuestion)
        );
    }
}
