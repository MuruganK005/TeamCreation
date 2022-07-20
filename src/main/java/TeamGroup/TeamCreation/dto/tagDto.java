package TeamGroup.TeamCreation.dto;

import TeamGroup.TeamCreation.Entity.Plays;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class tagDto {
    private Long id;
    private String tagName;
    private String tagAccountId;
    private String tagColor;
    private Date created_at;
    private Date updated_at;
    private Set<Plays> plays=new HashSet<>();
}
