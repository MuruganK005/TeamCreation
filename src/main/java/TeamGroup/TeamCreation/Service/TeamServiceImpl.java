package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Entity.Team;
import TeamGroup.TeamCreation.Exception.TeamException;
import TeamGroup.TeamCreation.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team)throws Exception {
        Team team1=teamRepository.findByTeamNameAndAccountId(team.getTeamName(),team.getAccountId());
        if (team1 != null){
            throw new TeamException(HttpStatus.FORBIDDEN,"TeamName Already Exist in This AccountId");
        }
            return teamRepository.save(team);
    }

    @Override
    public List<Team> showTeamAccountId(String accountId) {
        return (List<Team>) teamRepository.findByAccountId(accountId);
    }

    @Override
    public Team updateAccount(Team team) throws Exception{
        Optional<Team> team2= teamRepository.findById(team.getId());
        if (!team2.isPresent()) {
            throw new TeamException(HttpStatus.FORBIDDEN,"Record does not exist");
        }
        team2.get().setTeamName(team.getTeamName());
        return teamRepository.save(team2.get());
    }
    @Override
    public void DeleteTeamById(Long id){
        System.out.println(id+"Successfully Deleted");
        teamRepository.deleteById(id);
    }
    @Override
    public List<Team> showAllTeamAccountId() {
        return teamRepository.findAll();
    }
    @Override
    public List<Team> paginatingTeam(Integer pageNumber, Integer pageSize, String teamName) {
        PageRequest pageable1= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"teamName");
        return teamRepository.paginatingTeam(pageable1,teamName);
    }
}
