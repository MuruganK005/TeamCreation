package TeamGroup.TeamCreation.Controller;

import TeamGroup.TeamCreation.Entity.Plays;
import TeamGroup.TeamCreation.Service.PlayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plays")
public class PlayController {
    @Autowired
    private PlayServiceImpl playServiceImpl;
    @PostMapping("/createPlays")
    public Plays createPlays(@RequestBody Plays plays){
        return playServiceImpl.createPlays(plays);
    }
    @PutMapping("/updatePlays")
    public Plays updatePlays(@RequestBody Plays plays){
        return playServiceImpl.updatePlays(plays);
    }
    @GetMapping("/getByIdPlays/{id}")
    public Optional<Plays> getByIdPlays(@PathVariable Long id){
        return playServiceImpl.getByIdPlays(id);
    }
    @GetMapping("/getAllPlays")
    public List<Plays> getAllPlays(){
        return playServiceImpl.getAllPlays();
    }
    @DeleteMapping("/getByIdPlays/{id}")
    public void deleteByIdPlays(@PathVariable Long id) {
         playServiceImpl.deleteByIdPlays(id);
    }
    @GetMapping("/deleteAllPlays")
    public void deleteAllPlays( ){

        playServiceImpl.deleteAllPlays();
    }
}
