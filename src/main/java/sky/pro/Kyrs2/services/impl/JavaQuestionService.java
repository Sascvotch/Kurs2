package sky.pro.Kyrs2.services.impl;

import org.springframework.stereotype.Service;
import sky.pro.Kyrs2.data.Question;
import sky.pro.Kyrs2.exception.InvalidArgumentException;
import sky.pro.Kyrs2.exception.QuestionAlreadyExist;
import sky.pro.Kyrs2.services.QuestionService;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    private final Map<String, Question> questionMap = new HashMap<>(Map.of(
            "Вопрос1Ответ1", new Question("Вопрос1", "Ответ1"),
            "Вопрос2Ответ2", new Question("Вопрос2", "Ответ2"),
            "Вопрос3Ответ3", new Question("Вопрос3", "Ответ3"),
            "Вопрос4Ответ4", new Question("Вопрос4", "Ответ4"),
            "Вопрос5Ответ5", new Question("Вопрос5", "Ответ5")
    ));

    public Question add(String question, String answer) throws MyException {
        if (question == null || answer == null) {
            throw new InvalidArgumentException();
        }
        if (questionMap.containsKey(question+answer)) throw new MyException("Такой вопрос уже есть");
        Question questionAdd = new Question(question, answer);
        questionMap.put(question + answer, questionAdd);
        System.out.println("Вопрос1: " + question + " с ответом: " + answer + " добавлен.");
        return questionAdd;
    }

    public int size() {
        return questionMap.size();
    }

    public Question add(Question question) throws MyException {
        if (question == null ) {
            throw new InvalidArgumentException();
        }
        EmployeeAlreadyExists(questionMap, question);
        questionMap.put(question.getQuestion() + question.getAnswer(), question);
        System.out.println("Вопрос1: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " добавлен.");
        return question;
    }

    public Question find(Question question) throws MyException {
        if (question == null ) {
            throw new InvalidArgumentException();
        }
        if (!questionMap.containsKey(question.getQuestion()+question.getAnswer())) throw new MyException("Такой вопрос не найден");
        questionMap.get(question.getQuestion() + question.getAnswer());
        System.out.println("Вопрос: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " найден.");
        return question;
    }

    public Question remove(Question question) throws MyException {
        if (question == null ) {
            throw new InvalidArgumentException();
        }
        if (!questionMap.containsKey(question.getQuestion()+question.getAnswer())) throw new MyException("Такой вопрос не найден");
        questionMap.remove(question.getQuestion() + question.getAnswer(), question);
        System.out.println("Вопрос1: " + question.getQuestion() + " с ответом: " + question.getAnswer() + " удален.");
        return question;
    }

    public Collection<Question> getAll() {
        return new ArrayList<Question>(questionMap.values());
    }
    public void removeAll() {
        questionMap.clear();
    }
    public Question getRandomQuestion() {
        List<Question> questionList = questionMap.entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
        Random ran = new Random();
        int nxt = ran.nextInt(questionMap.size());
        return questionList.get(nxt);
    }
    public void EmployeeAlreadyExists(Map questionMap, Question currentQuestion) {
        if (questionMap.containsKey(currentQuestion.getQuestion() + currentQuestion.getAnswer())) {
            throw new QuestionAlreadyExist();
        }
    }
    public static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
}
