package gogo.mission3.Controller;

import gogo.mission3.Exception.MusicNotFoundException;
import gogo.mission3.MusicModel;
import gogo.mission3.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getMusic(@PathVariable("id") Integer id) {
        Optional<MusicModel> music = Optional.ofNullable(musicRepo.getMusic(id));
        if (music.isEmpty()) {
            throw new MusicNotFoundException(id);
        } else {
            return ResponseEntity.ok(music);
        }
    }

    @PostMapping("/music")
    public String addMusic (@RequestBody MusicModel musicModel) {

        return musicRepo.addMusic(musicModel);
    }

    @PutMapping("/music/{id}")
    public void updateMusic (@PathVariable Integer id, @RequestBody MusicModel musicModel) {
        musicRepo.updateMusic(id, musicModel);

    }

    @DeleteMapping("/music/{id}")
    public int deleteMusic(@PathVariable Integer id){

        return  musicRepo.deleteMusic(id);
    }

}
