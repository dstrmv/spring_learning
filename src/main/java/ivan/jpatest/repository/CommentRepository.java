package ivan.jpatest.repository;

import ivan.jpatest.model.TextComment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<TextComment, Long> {
}
