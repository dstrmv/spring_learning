package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTaskJournal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "taskjournals", path = "taskjournals", excerptProjection = TaskJournalProjection.class)
public interface TaskJournalRepository extends PagingAndSortingRepository<SimpleTaskJournal, Long> {



}
