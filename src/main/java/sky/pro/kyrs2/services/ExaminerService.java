package sky.pro.kyrs2.services;

import sky.pro.kyrs2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(Integer amount);
}
