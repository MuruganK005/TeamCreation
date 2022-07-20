package TeamGroup.TeamCreation.dto;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Entity.Tags;
import TeamGroup.TeamCreation.Entity.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class playDto {
    private Long id;
    private String playName;
    private Date created_at;
    private Date updated_at;
    private Series series;
    private Team team;
    private List<Tags> tag=new ArrayList<>();

}
