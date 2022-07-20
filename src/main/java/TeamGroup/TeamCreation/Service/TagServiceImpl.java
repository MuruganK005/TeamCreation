package TeamGroup.TeamCreation.Service;

import TeamGroup.TeamCreation.Entity.Tags;
import TeamGroup.TeamCreation.Exception.TeamException;
import TeamGroup.TeamCreation.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    @Override
    public Tags createTags(Tags tags)throws Exception {
        Tags tags11=tagRepository.findByTagNameAndTagColor(tags.getTagName(),tags.getTagColor());
        if (tags11 != null){
            throw new TeamException(HttpStatus.FORBIDDEN,"TagName Already Exist in This TagColor");
        }
        return tagRepository.save(tags);
    }
    @Override
    public List<Tags> updateTags(Tags tags) throws Exception{
        Optional<Tags> tags22= tagRepository.findById(tags.getId());
        if (!tags22.isPresent()) {
            throw new TeamException(HttpStatus.FORBIDDEN,"Record does not exist");
        }
        Optional<Tags> tags33= tagRepository.findByTagName(tags.getTagName());
        if (tags33.isPresent() && tags33.get().getId() != tags.getId()) {
            throw new TeamException(HttpStatus.FORBIDDEN,"TagName Already Exist in Another Id");
        }
        Optional<Tags> tags44= tagRepository.findByTagColor(tags.getTagColor());
        if (tags44.isPresent() && tags44.get().getId() != tags.getId()) {
            throw new TeamException(HttpStatus.FORBIDDEN,"TagColor Already Exist in Another Id");
        }
        tags22.get().setTagName(tags.getTagName());
        tags22.get().setTagColor(tags.getTagColor());
        return (List<Tags>) tagRepository.save(tags22.get());
    }
    @Override
    public List<Tags> getTags(String tagName){
        return tagRepository.getTags(tagName);
    }
    @Override
    public List<Tags> getAllTags() {
        return tagRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
         tagRepository.deleteById(id);
    }

    @Override
    public List<Tags> paginatingTagsService(Integer PageNumber,Integer PageSize,String tagName) {
        PageRequest pageable1= PageRequest.of(PageNumber,PageSize,Sort.DEFAULT_DIRECTION,"tagName","tagColor");
        return tagRepository.paginatingTagsService(pageable1, tagName);
    }

//    @Override
//    public Page<Tags> paginatingTags(Integer pageNumber, Integer pageSize, Pageable pageable) {
//        Pageable pageable1= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"tagName");
//        return tagRepository.paginatingTags(pageNumber,pageSize,pageable);
//    }
}
