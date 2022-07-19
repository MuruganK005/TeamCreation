package TeamGroup.TeamCreation.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seriesId;
    @Column(name = "SeriesName")
    private String seriesName;
    @Column(name = "SeriesAccountId")
    private String seriesAccountId;
    @OneToOne(mappedBy = "series")
    private Plays plays;
}
