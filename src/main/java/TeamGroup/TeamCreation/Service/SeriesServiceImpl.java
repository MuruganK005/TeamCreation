package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Exception.TeamException;
import TeamGroup.TeamCreation.Repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImpl implements SeriesService{
    @Autowired
    private SeriesRepository seriesRepository;
    @Override
    public Series createSeries(Series series)throws Exception {
        Series series1=seriesRepository.findBySeriesNameAndSeriesAccountId(series.getSeriesName(),series.getSeriesAccountId());
        if (series1 != null){
            throw new TeamException(HttpStatus.FORBIDDEN,"SeriesName Already Exist in This SeriesAccountId");
        }
        return seriesRepository.save(series);
    }
    @Override
    public Series updateSeries(Series series) throws TeamException {
        Optional<Series> series2= seriesRepository.findById(series.getId());
        if (!series2.isPresent()) {
            throw new TeamException(HttpStatus.FORBIDDEN,"Record does not exist");
        }
        series2.get().setSeriesName(series.getSeriesName());
        return seriesRepository.save(series2.get());
    }
    @Override
    public List<Series> showAllSeries() {
        return seriesRepository.findAll();

    }
    @Override
    public List<Series> showSeriesAccountId(String seriesAccountId) {
        return seriesRepository.findBySeriesAccountId(seriesAccountId);
    }
    @Override
    public void DeleteTeamById(Long id) {
        seriesRepository.deleteById(id);
    }
    @Override
    public List<Series> paginatingSeries(Integer pageNumber, Integer pageSize, String seriesName) {
        PageRequest pageable1= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"seriesName");
        return seriesRepository.paginatingSeries(pageable1,seriesName);
    }
}
