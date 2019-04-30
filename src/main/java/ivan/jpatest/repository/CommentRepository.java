package ivan.jpatest.repository;

import ivan.jpatest.model.TextComment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "comments", path = "comments", excerptProjection = CommentProjection.class)
public interface CommentRepository extends PagingAndSortingRepository<TextComment, Long> {
}
