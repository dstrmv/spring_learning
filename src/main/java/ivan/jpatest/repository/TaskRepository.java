package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks", excerptProjection = TaskProjection.class)
public interface TaskRepository extends CrudRepository<SimpleTask, Long> {
}
