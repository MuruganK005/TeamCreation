package TeamGroup.TeamCreation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TeamName")
    private String teamName;
    @Column(name = "AccountId")
    private String accountId;
    private Date created_at=new Date();
    private Date updated_at=new Date();
    @OneToOne(mappedBy = "team")
    private Plays plays;

}
