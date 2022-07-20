package TeamGroup.TeamCreation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SeriesName")
    private String seriesName;
    @Column(name = "SeriesAccountId")
    private String seriesAccountId;
    private Date created_at=new Date();
    private Date updated_at=new Date();
    @OneToOne(mappedBy = "series")
    private Plays plays;
}
