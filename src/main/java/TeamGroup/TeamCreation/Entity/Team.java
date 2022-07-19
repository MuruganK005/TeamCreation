package TeamGroup.TeamCreation.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TeamName")
    private String teamName;
    @Column(name = "AccountId")
    private String accountId;
    @OneToOne(mappedBy = "team")
    private Plays plays;

}
