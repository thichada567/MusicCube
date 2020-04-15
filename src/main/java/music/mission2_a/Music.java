package music.mission2_a;

import com.fasterxml.jackson.databind.JavaType;
import com.google.gson.Gson;
import music.mission2_a.Model.MusicModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class Music {
    List<MusicModel> musicList = new ArrayList<MusicModel>();
    private static final String version = "/v1";
    private static final String getUrl = version + "/music";

    private List<MusicModel> mss = new ArrayList<>(Arrays.asList(
            new MusicModel("0001", "Movie", "Tom Misch"),
            new MusicModel("0003","Congratulations","Eric Nam"),
            new MusicModel("0004","June","Charlie Burg"),
            new MusicModel("0005","Dance","offonoff"),
            new MusicModel("0006","Too Difficult","Thicha"))
    );
    private JavaType id;

    @RequestMapping("/")
    @ResponseBody
    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getMusic() {
        return new Gson().toJson(mss);
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.POST)
    @ResponseBody
    public void setMusic(@RequestBody MusicModel music) {
        musicList.add(music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateMusic(@PathVariable("id") String id, @RequestBody MusicModel music) {
        if (!musicList.isEmpty() || musicList != null) {
            for (MusicModel item : musicList) {
                if (item.id.toString().equals(id)) {
                    item.SongName = music.SongName;
                    item.Artist = music.Artist;
                    break;
                }
            }
        }
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMusic(@PathVariable("id") String id) {

        if (!musicList.isEmpty() || musicList != null) {
            /*
            Iterator<Music> obj = musicList.iterator();
            while(obj.hasNext()){
                Music music = obj.next();
                if(music.id.toString().equals(id)){
                    obj.remove();
                }
            }
            */
//            for (var obj : musicList) {
//                if (obj.id.toString().equals(id)) {
//                    musicList.remove(obj);
//                }
//            }
        }
    }
}
