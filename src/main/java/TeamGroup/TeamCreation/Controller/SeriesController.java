package TeamGroup.TeamCreation.Controller;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Service.SeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesTest")
public class SeriesController {
    @Autowired
    private SeriesServiceImpl seriesServiceImpl;
    @PostMapping("/create")
    public Series createSeries(@RequestBody Series series)throws Exception{
        return seriesServiceImpl.createSeries(series);
    }
    @PutMapping("/update")
    public Series updateSeries(@RequestBody Series series)throws Exception{
        return seriesServiceImpl.updateSeries(series);
    }
    @GetMapping("/showSeries")
    public List<Series> showSeriesAccountId(@RequestParam String seriesAccountId){
        return seriesServiceImpl.showSeriesAccountId(seriesAccountId);
    }
    @GetMapping("/showAllSeries")
    public List<Series> showAllSeries() {
        return seriesServiceImpl.showAllSeries();
    }
    @DeleteMapping("/{id}")
    public void DeleteTeamById(@PathVariable Long id){
        seriesServiceImpl.DeleteTeamById(id);
    }
    @GetMapping("/pagination/{PageNumber}/{PageSize}")
    public List<Series> paginatingSeries(@PathVariable Integer PageNumber, @PathVariable Integer PageSize, @RequestParam String seriesName){
        return seriesServiceImpl.paginatingSeries(PageNumber,PageSize,seriesName);

    }
}
