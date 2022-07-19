package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Tags;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TagService {
    public Tags createTags(Tags tags) throws Exception;

    public List<Tags> updateTags(Tags tags) throws Exception;

    public List<Tags> getTags(String tagName);

    public List<Tags> getAllTags();

    public void deleteById(Long id);

   public List<Tags> paginatingTagsService(Integer PageNumber, Integer PageSize,String tagName);

//    Page<Tags> paginatingTags(Integer pageNumber, Integer pageSize, Pageable pageable);
}
