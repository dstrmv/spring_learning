package ivan.jpatest.repository;

import ivan.jpatest.model.TextComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments", excerptProjection = CommentProjection.class)
public interface CommentRepository extends CrudRepository<TextComment, Long> {
}
