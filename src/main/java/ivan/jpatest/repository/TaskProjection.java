package ivan.jpatest.repository;

import ivan.jpatest.model.SimpleTask;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name="taskProjection", types = {SimpleTask.class})
public interface TaskProjection {

    Long getId();
    String getName();
    String getDescription();
    LocalDateTime getExpires();
    boolean isActive();
    List<CommentProjection> getComments();

}
