package ivan.jpatest.repository;

import ivan.jpatest.model.TextComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository extends PagingAndSortingRepository<TextComment, Long> {
}
