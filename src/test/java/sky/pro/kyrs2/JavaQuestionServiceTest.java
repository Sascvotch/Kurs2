package sky.pro.kyrs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.kyrs2.data.Question;
import sky.pro.kyrs2.services.impl.JavaQuestionService;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class JavaQuestionServiceTest {

    private JavaQuestionService out = new JavaQuestionService();
    private final Set<Question> questionSet = new HashSet<>(Set.of(
            new Question("Вопрос1", "Ответ1"),
            new Question("Вопрос2", "Ответ2")
    ));

    public static Stream<Arguments> provideParamsForAddTest() {
        return Stream.of(
                Arguments.of("Вопрос8", "Ответ8"),
                Arguments.of("Вопрос9", "Ответ9")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddTest")
    public void addTest(String question, String answer) {
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
    public void findTest(Question question) {
        Question expected = out.add(question);
        Question actual = out.find(question);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForQuestionTest")
    public void removeTest(Question question) {
        out.add(question);
        out.remove(question);
        Assertions.assertThrows(RuntimeException.class, () -> out.find(question));
    }

    @Test
    public void getAllTest() {
        out.removeAll();
        Collection<Question> expected = new HashSet<>(Set.of(new Question("Вопрос10", "Ответ10"),
                new Question("Вопрос20", "Ответ20")));
        out.add("Вопрос10", "Ответ10");
        out.add("Вопрос20", "Ответ20");
        assertEquals(expected, out.getAll());

    }
    public static Stream<Arguments> provideParamsForQuestionAlreadyExistsTest() {
        Question currentQuestion = new Question("Вопрос1", "Ответ1");
        Set<Question> questionSet = new HashSet<>(Set.of(
               currentQuestion
        ));
        return Stream.of(Arguments.of(questionSet, currentQuestion));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForQuestionAlreadyExistsTest")
    public void employeeAlreadyExistsTest(Set<Question> questionSet, Question currentQuestion)  {
        assertThrows(RuntimeException.class,
                () -> out.add(currentQuestion)
        );
    }

}
