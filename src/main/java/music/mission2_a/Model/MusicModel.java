package music.mission2_a.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity
@ToString
@AllArgsConstructor
public class MusicModel {
    public String id;
    public String SongName;
    public String Artist;

}
