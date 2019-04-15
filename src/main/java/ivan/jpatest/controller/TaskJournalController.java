package ivan.jpatest.controller;

import ivan.jpatest.model.SimpleTaskJournal;
import ivan.jpatest.repository.TaskJournalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TaskJournalController {

    private TaskJournalRepository taskJournalRepository;

    public TaskJournalController(TaskJournalRepository taskJournalRepository) {
        this.taskJournalRepository = taskJournalRepository;
    }

    @GetMapping("/taskjournals")
    Iterable<SimpleTaskJournal> allTaskJournals() {
        return taskJournalRepository.findAll();
    }

    @GetMapping("/taskjournals/{id}")
    Optional<SimpleTaskJournal> oneTaskJournal(@PathVariable Long id) {
        return taskJournalRepository.findById(id);
    }
}
