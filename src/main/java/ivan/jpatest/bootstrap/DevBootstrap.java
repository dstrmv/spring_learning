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

        TextComment comment3 = new TextComment("comment for task 2");

        SimpleTask task1 = new SimpleTask();
        SimpleTask task2 = new SimpleTask();

        task1.setActive(true);
        task1.setName("this is simple task");
        task1.setDescription("this is task description");
        task1.setExpires(LocalDateTime.now());
        task1.getComments().add(comment);
        task1.getComments().add(comment2);

        task2.setActive(true);
        task2.setName("task 2");
        task2.setDescription("second task");
        task2.setExpires(LocalDateTime.now());

        SimpleTaskJournal taskJournal = new SimpleTaskJournal();
        taskJournal.setName("journal name");
        taskJournal.setDescription("description tj");
        taskJournal.getTasks().add(task1);
        taskJournal.getTasks().add(task2);

        taskJournalRepository.save(taskJournal);

        //taskRepository.save(task);

        //commentRepository.save(comment);
        //commentRepository.save(comment2);



    }
}
