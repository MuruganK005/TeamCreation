package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Series;
import TeamGroup.TeamCreation.Exception.TeamException;

import java.util.List;

public interface SeriesService {
    public Series createSeries(Series series) throws Exception;

   public Series updateSeries(Series series) throws TeamException;

    public List<Series> showAllSeries();

    public List<Series> showSeriesAccountId(String seriesAccountId);

    public void DeleteTeamById(Long id);

    List<Series> paginatingSeries(Integer pageNumber, Integer pageSize, String seriesName);
}
