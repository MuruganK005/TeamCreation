package TeamGroup.TeamCreation.dto;

import TeamGroup.TeamCreation.Entity.Plays;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class teamDto {
    private Long id;
    private String teamName;
    private String accountId;
    private Date created_at;
    private Date updated_at;
    private Plays plays;
}
