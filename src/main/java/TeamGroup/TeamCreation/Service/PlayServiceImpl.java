package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Plays;
import TeamGroup.TeamCreation.Repository.PlaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayServiceImpl implements PlayServiceImpls {
    @Autowired
    private PlaysRepository playsRepository;
    @Override
    public Plays createPlays(Plays plays) {
        return playsRepository.save(plays);
    }
    public Plays updatePlays(Plays plays) {
        return playsRepository.save(plays);
    }
    @Override
    public List<Plays> getAllPlays() {
        return playsRepository.findAll();
    }
    @Override
    public Optional<Plays> getByIdPlays(Long id) {
        return playsRepository.findById(id);
    }
    @Override
    public void deleteByIdPlays(Long id) {
         playsRepository.deleteById(id);

    }
    @Override
    public void deleteAllPlays() {
         playsRepository.deleteAll();
    }
}
