package TeamGroup.TeamCreation.Repository;

import TeamGroup.TeamCreation.Entity.Plays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaysRepository extends JpaRepository<Plays,Long> {
}
