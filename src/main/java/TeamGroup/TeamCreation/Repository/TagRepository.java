package TeamGroup.TeamCreation.Repository;

import TeamGroup.TeamCreation.Entity.Tags;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {

    Tags findByTagNameAndTagColor(String tagName, String tagColor);
    @Query(value="SELECT c FROM Tags c WHERE c.tagName like %:tagName%")
    List<Tags> getTags(String tagName);

    Optional<Tags> findByTagName(String tagName);

    Optional<Tags> findByTagColor(String tagColor);

//    @Query(value="SELECT c FROM Tags c WHERE c.tagName like %:tagName%")
//    Page<Tags> paginatingTags(Integer pageNumber, Integer pageSize, Pageable pageable);
//    @Query(value="SELECT c FROM Tags c WHERE c.tagName like %:tagName%")
//    Page<Tags> paginatingTags(Integer pageNumber, Integer pageSize,Pageable pageable);
    @Query(value="SELECT c FROM Tags c WHERE c.tagName like %:tagName%")
    List<Tags> paginatingTagsService(Pageable pageable,String tagName);

//    Optional<Tags> findByTagName1(String tagName);
}
