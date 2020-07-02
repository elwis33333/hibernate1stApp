package one_to_one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTimestamp;

    private String redactor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public String toString() {
        return "PostDetails{" +
                "id=" + id +
                ", creationTimestamp=" + creationTimestamp +
                ", modificationTimestamp=" + modificationTimestamp +
                ", redactor='" + redactor + '\'' +
                '}';
    }
}