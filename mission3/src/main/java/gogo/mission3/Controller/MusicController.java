package gogo.mission3.Controller;

import gogo.mission3.MusicModel;
import gogo.mission3.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MusicController {
    @Autowired
    MusicRepository musicRepo;

    @GetMapping("/music/cube")
    public List<MusicModel> getAllMusics() {
        return musicRepo.selectAll();
    }

    @GetMapping("/music/cube/{id}")
    public MusicModel getMusic(@RequestParam("id") int id) {
        return musicRepo.getMusic(id);
    }

    @PostMapping("/music/add")
    public String addMusic (@RequestBody MusicModel musicModel) {
        return musicRepo.addMusic(musicModel);
    }

    @PutMapping("/music/update/{id}")
    public void updateMusic (@PathVariable int id, @RequestBody MusicModel musicModel) {
        musicRepo.updateMusic(id, musicModel);

    }

    @DeleteMapping("/music/delete/{id}")
    public int deleteMusic(@PathVariable int id){
        return  musicRepo.deleteMusic(id);
    }

}
