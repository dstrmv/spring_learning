package ivan.jpatest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class SimpleTaskJournal {

    public SimpleTaskJournal() {
        this.tasks = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SimpleTask> tasks;
}
