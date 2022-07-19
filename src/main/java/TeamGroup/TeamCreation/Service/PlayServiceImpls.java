package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Plays;

import java.util.List;
import java.util.Optional;

public interface PlayServiceImpls {
   public Plays createPlays(Plays plays);

   public Plays updatePlays(Plays plays);

   public List<Plays> getAllPlays();

   public Optional<Plays> getByIdPlays(Long id);

   void deleteByIdPlays(Long id);

   void deleteAllPlays();
}
