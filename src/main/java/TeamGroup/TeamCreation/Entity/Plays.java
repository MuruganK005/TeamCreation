package TeamGroup.TeamCreation.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "plays")
@EntityListeners(AuditingEntityListener.class)
public class Plays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PlayName")
    private String playName;
    private Date created_at=new Date();
    private Date updated_at=new Date();
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "series_id")
    private Series series;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "Play_Tags",
                joinColumns = @JoinColumn(name = "play_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tags> tag=new ArrayList<>();

}
