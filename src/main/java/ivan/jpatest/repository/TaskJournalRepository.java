package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTaskJournal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "taskjournals", path = "taskjournals", excerptProjection = TaskJournalProjection.class)
public interface TaskJournalRepository extends CrudRepository<SimpleTaskJournal, Long> {



}
