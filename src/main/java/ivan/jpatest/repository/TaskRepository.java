package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTask;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks", excerptProjection = TaskProjection.class)
public interface TaskRepository extends PagingAndSortingRepository<SimpleTask, Long> {
}
