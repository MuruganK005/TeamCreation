package TeamGroup.TeamCreation.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "Tags")
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;
    @Column(name = "TagName")
    private String tagName;
    @Column(name = "TagAccountId")
    private String tagAccountId;
    @Column(name = "TagColor")
    private String tagColor;
    @ManyToMany(mappedBy = "tag")
    private Set<Plays> plays=new HashSet<>();

}
