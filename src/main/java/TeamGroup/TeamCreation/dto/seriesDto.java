package TeamGroup.TeamCreation.dto;

import TeamGroup.TeamCreation.Entity.Plays;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class seriesDto {
    private Long id;
    private String seriesName;
    private String seriesAccountId;
    private Date created_at;
    private Date updated_at;
    private Plays plays;
}
