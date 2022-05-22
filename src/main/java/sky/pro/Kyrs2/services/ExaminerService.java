package sky.pro.Kyrs2.services;

import sky.pro.Kyrs2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestion(int amount);
}
