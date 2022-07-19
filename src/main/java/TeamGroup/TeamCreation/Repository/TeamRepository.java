package TeamGroup.TeamCreation.Repository;

import TeamGroup.TeamCreation.Entity.Team;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
//     Team sortingPages(Sort.Direction desc, String team);

    Team findByTeamNameAndAccountId(String teamName, String accountId);
    List<Team> findByAccountId(String accountId);
    @Query(value="SELECT c FROM Team c WHERE c.teamName like %:teamName%")
    List<Team> paginatingTeam(Pageable pageable, String teamName);
}
