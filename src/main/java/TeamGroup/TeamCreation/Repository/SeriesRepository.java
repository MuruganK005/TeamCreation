package TeamGroup.TeamCreation.Repository;

import TeamGroup.TeamCreation.Entity.Series;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {

    List<Series> findBySeriesAccountId(String seriesAccountId);

    Series findBySeriesNameAndSeriesAccountId(String seriesName, String seriesAccountId);
    @Query(value="SELECT c FROM Series c WHERE c.seriesName like %:seriesName%")
    List<Series> paginatingSeries(Pageable pageable, String seriesName);
}
