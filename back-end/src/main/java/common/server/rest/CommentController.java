package common.server.rest;

import common.server.domain.Comment;
import common.server.exception.NotFoundException;
import common.server.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping(value = "{id}")
    public Comment findById(@PathVariable Long id) throws NotFoundException {
        return service.findById(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteComment(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return service.add(comment);
    }

}