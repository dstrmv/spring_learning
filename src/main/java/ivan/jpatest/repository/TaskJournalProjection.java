package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTask;
import ivan.jpatest.model.SimpleTaskJournal;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name="taskJournalProjection", types = {SimpleTaskJournal.class, SimpleTask.class})
public interface TaskJournalProjection {

    Long getId();
    String getName();
    String getDescription();

    List<TaskProjection> getTasks();

}
