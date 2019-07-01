package common.server.service.impl;

import common.server.domain.Question;
import common.server.exception.NotFoundException;
import common.server.repository.QuestionRepository;
import common.server.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionRepository repo;

    @Override
    public Question add(Question question) throws NotFoundException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        question.setUser(userService.findUserByUsername(username));
        return repo.save(question);
    }

    @Override
    public Question findById(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("QUESTION.NOT.FOUND", "Question not found with id : " + id);
        return repo.findById(id).get();
    }

    @Override
    public List<Question> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("QUESTION.NOT.FOUND", "Question not found with id : " + id);
        repo.deleteById(id);
    }

    @Override
    public List<Question> searchQuestions(Question questionDto) {
        throw new RuntimeException("Not Implemented Yet");
    }

}