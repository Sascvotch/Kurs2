package sky.pro.kyrs2.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.kyrs2.data.Question;
import sky.pro.kyrs2.exception.InvalidArgumentException;
import sky.pro.kyrs2.exception.QuestionAlreadyExistException;
import sky.pro.kyrs2.services.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionSet = new HashSet<>(Set.of(
            new Question("Вопрос1", "Ответ1"),
            new Question("Вопрос2", "Ответ2"),
            new Question("Вопрос3", "Ответ3"),
            new Question("Вопрос4", "Ответ4"),
            new Question("Вопрос5", "Ответ5")
    ));
    private final Random ran = new Random();

    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new InvalidArgumentException();
        }
        Question questionAdd = new Question(question, answer);
        if (questionSet.contains(questionAdd)) {
            throw new QuestionAlreadyExistException();
        }
        questionSet.add(questionAdd);
        System.out.println("Вопрос1: " + question + " с ответом: " + answer + " добавлен.");
        return questionAdd;
    }

    public int size() {
        return questionSet.size();
    }

    public Question add(Question question) {
        if (question == null) {
            throw new InvalidArgumentException();
        }
        if (questionSet.contains(question)) {
            throw new QuestionAlreadyExistException();
        }
        questionSet.add(question);
        System.out.println("Вопрос1: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " добавлен.");
        return question;
    }

    public Question find(Question question) {
        if (question == null || !questionSet.contains(question)) {
            throw new InvalidArgumentException();
        }
        System.out.println("Вопрос: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " найден.");
        return question;
    }

    public Question remove(Question question) {
        if (question == null) {
            throw new InvalidArgumentException();
        }
        if (!questionSet.contains(question)) {
            throw new InvalidArgumentException();
        }
        questionSet.remove(question);
        System.out.println("Вопрос1: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " удален.");
        return question;
    }

    public Collection<Question> getAll() {
        return questionSet;//new ArrayList<Question>(questionMap);
    }

    public void removeAll() {
        questionSet.clear();
    }

    public Question getRandomQuestion() {
        List<Question> questionList = questionSet.stream()
                .collect(Collectors.toList());
        int nxt = ran.nextInt(questionSet.size());
        return questionList.get(nxt);
    }

}
