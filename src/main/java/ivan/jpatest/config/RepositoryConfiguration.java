package ivan.jpatest.config;

import ivan.jpatest.model.SimpleTask;
import ivan.jpatest.model.SimpleTaskJournal;
import ivan.jpatest.model.TextComment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(SimpleTaskJournal.class);
        config.exposeIdsFor(SimpleTask.class);
        config.exposeIdsFor(TextComment.class);
    }
}
