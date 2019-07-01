package common.server.service;

import common.server.domain.Comment;
import common.server.exception.NotFoundException;

import java.util.List;

public interface ICommentService {

	Comment add(Comment comment);

	Comment findById(long id) throws NotFoundException;

	List<Comment> findAll();

	void delete(long id) throws NotFoundException;

}
