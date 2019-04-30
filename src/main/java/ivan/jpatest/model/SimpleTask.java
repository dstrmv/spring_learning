package ivan.jpatest.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SimpleTask {

    public SimpleTask() {
        this.comments = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime expires;
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TextComment> comments;

    @ManyToOne
    private SimpleTaskJournal simpleTaskJournal;

}
