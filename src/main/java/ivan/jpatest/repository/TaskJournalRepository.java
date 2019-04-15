package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTaskJournal;
import org.springframework.data.repository.CrudRepository;

public interface TaskJournalRepository extends CrudRepository<SimpleTaskJournal, Long> {



}
