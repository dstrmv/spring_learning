package ivan.jpatest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class TextComment {

    public TextComment(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @ManyToOne
    private SimpleTask simpleTask;

}
