package ivan.jpatest.bootstrap;

import ivan.jpatest.model.SimpleTask;
import ivan.jpatest.model.SimpleTaskJournal;
import ivan.jpatest.model.TextComment;
import ivan.jpatest.repository.CommentRepository;
import ivan.jpatest.repository.TaskJournalRepository;
import ivan.jpatest.repository.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TaskRepository taskRepository;
    private CommentRepository commentRepository;
    private TaskJournalRepository taskJournalRepository;

    public DevBootstrap(TaskRepository taskRepository, CommentRepository commentRepository, TaskJournalRepository taskJournalRepository) {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.taskJournalRepository = taskJournalRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        TextComment comment = new TextComment("this is comment 1");
        TextComment comment2 = new TextComment("this is comment 2");

        SimpleTask task = new SimpleTask();
        task.setActive(true);
        task.setName("this is simple task");
        task.setDescription("this is task description");
        task.setExpires(LocalDateTime.now());
        task.getComments().add(comment);
        task.getComments().add(comment2);

        SimpleTaskJournal taskJournal = new SimpleTaskJournal();
        taskJournal.setName("taskjournal");
        taskJournal.setDescription("description tj");
        taskJournal.getTasks().add(task);

        taskJournalRepository.save(taskJournal);

        //taskRepository.save(task);

        //commentRepository.save(comment);
        //commentRepository.save(comment2);



    }
}
