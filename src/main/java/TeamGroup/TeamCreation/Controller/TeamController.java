package TeamGroup.TeamCreation.Controller;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Entity.Team;
import TeamGroup.TeamCreation.Repository.TeamRepository;
import TeamGroup.TeamCreation.Service.TeamServiceImpl;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Api/TeamTest")
public class TeamController {
    @Autowired
    private TeamServiceImpl teamServiceImpl;
    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) throws Exception {
        return teamServiceImpl.createTeam(team);
    }
    @GetMapping("/showTeam")
    public List<Team> showTeamAccountId(@RequestParam String accountId) {
        return teamServiceImpl.showTeamAccountId(accountId);
    }
    @GetMapping("/showAllTeam")
    public List<Team> showAllTeamAccountId()  {
        return teamServiceImpl.showAllTeamAccountId();
    }
    @PutMapping("/updateTeam")
    public Team updateAccount(@RequestBody Team team) throws Exception {
        return teamServiceImpl.updateAccount(team);
    }
    @DeleteMapping("/{id}")
    public void DeleteTeamById(@PathVariable Long id){
         teamServiceImpl.DeleteTeamById(id);
    }
    @GetMapping("/pagination/{PageNumber}/{PageSize}")
    public List<Team> paginatingTeam(@PathVariable Integer PageNumber,
                                     @PathVariable Integer PageSize,
                                     @RequestParam String teamName){
        return teamServiceImpl.paginatingTeam(PageNumber,PageSize,teamName);
    }
}
