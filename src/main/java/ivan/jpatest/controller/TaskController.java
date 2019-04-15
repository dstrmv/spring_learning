package ivan.jpatest.controller;

import ivan.jpatest.model.SimpleTask;
import ivan.jpatest.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    Iterable<SimpleTask> allTasks() {
        return taskRepository.findAll();
    }
}
