package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTask;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<SimpleTask, Long> {
}
