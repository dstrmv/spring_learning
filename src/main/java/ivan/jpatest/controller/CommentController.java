package ivan.jpatest.controller;

import ivan.jpatest.model.TextComment;
import ivan.jpatest.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comments")
    Iterable<TextComment> allComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    Optional<TextComment> oneComment(@PathVariable Long id) {
        return commentRepository.findById(id);
    }


}
