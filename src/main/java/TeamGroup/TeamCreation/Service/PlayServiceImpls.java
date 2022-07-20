package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Plays;
import TeamGroup.TeamCreation.dto.playDto;

import java.util.List;
import java.util.Optional;

public interface PlayServiceImpls {
   public Plays createPlays(playDto playDto1);

   public Plays updatePlays(playDto playDto1);

   public List<Plays> getAllPlays();

   public Optional<Plays> getByIdPlays(Long id);

   void deleteByIdPlays(Long id);

   void deleteAllPlays();
}
