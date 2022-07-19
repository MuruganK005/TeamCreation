package TeamGroup.TeamCreation.Controller;

import TeamGroup.TeamCreation.Entity.Tags;
import TeamGroup.TeamCreation.Service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    @Autowired
    private TagServiceImpl tagServiceImpl;
    @PostMapping("/create")
    public Tags createTags(@RequestBody Tags tags)throws Exception{
        return tagServiceImpl.createTags(tags);
    }
    @PutMapping("/updateTags")
    public List<Tags> updateTags(@RequestBody Tags tags)throws Exception{
        return tagServiceImpl.updateTags(tags);
    }
    @GetMapping("/getTags")
    public List<Tags> getTags(@RequestParam String tagName){
        return tagServiceImpl.getTags(tagName);
    }
    @GetMapping("/getAllTags")
    public List<Tags> getAllTags(){
        return tagServiceImpl.getAllTags();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         tagServiceImpl.deleteById(id);
    }
    @GetMapping("/pagination/{PageNumber}/{PageSize}")
    public List<Tags> paginatingTagsService(@PathVariable Integer PageNumber, @PathVariable Integer PageSize,@RequestParam String tagName){
        return tagServiceImpl.paginatingTagsService(PageNumber,PageSize,tagName);

    }

//    @GetMapping("/pagination/{PageNumber}/{PageSize}/pageable")
//    public Page<Tags> paginatingTags(@PathVariable Integer PageNumber, @PathVariable Integer PageSize, Pageable pageable){
//        return tagServiceImpl.paginatingTags(PageNumber,PageSize,pageable);}

}
