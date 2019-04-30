package ivan.jpatest.repository;

import ivan.jpatest.model.TextComment;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="commentProjection", types = {TextComment.class})
public interface CommentProjection {

    String getContent();
    Long getId();

}
