package TeamGroup.TeamCreation.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "Tags")
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TagName")
    private String tagName;
    @Column(name = "TagAccountId")
    private String tagAccountId;
    @Column(name = "TagColor")
    private String tagColor;
    private Date created_at=new Date();
    private Date updated_at=new Date();
    @ManyToMany(mappedBy = "tag")
    private Set<Plays> plays=new HashSet<>();

}
