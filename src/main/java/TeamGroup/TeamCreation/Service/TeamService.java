package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Entity.Team;

import java.util.List;

public interface TeamService {
   public Team createTeam(Team team) throws Exception;

    public List<Team> showTeamAccountId(String accountId) throws Exception;

    public Team updateAccount(Team team)throws Exception;

    public void DeleteTeamById(Long id);

    List<Team> showAllTeamAccountId();

    List<Team> paginatingTeam(Integer pageNumber, Integer pageSize, String teamName);
}
