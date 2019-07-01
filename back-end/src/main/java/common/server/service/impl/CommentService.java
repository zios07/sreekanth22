package common.server.service.impl;

import common.server.domain.Comment;
import common.server.exception.NotFoundException;
import common.server.repository.CommentRepository;
import common.server.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository repo;

    @Override
    public Comment add(Comment comment) {
        return repo.save(comment);
    }

    @Override
    public Comment findById(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("COMMENT.NOT.FOUND", "Comment not found with id : " + id);
        return repo.findById(id).get();
    }

    @Override
    public List<Comment> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("COMMENT.NOT.FOUND", "Comment not found with id : " + id);
        repo.deleteById(id);
    }

}