package common.server.service;

import common.server.domain.Question;
import common.server.exception.NotFoundException;

import java.util.List;

public interface IQuestionService {

	Question add(Question question) throws NotFoundException;

	Question findById(long id) throws NotFoundException;

	List<Question> findAll();

	void delete(long id) throws NotFoundException;

	List<Question> searchQuestions(Question questionDto);
}
