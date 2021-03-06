package ivan.jpatest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    //@JsonFormat(pattern="dd.MM.yyyy, HH:mm:ss")
    private LocalDateTime expires;
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

    private List<TextComment> comments;

}
