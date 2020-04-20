package gogo.mission3;

import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@Data
public class MusicModel {

    @Column(nullable = false)
    private int id ;

    @Column(nullable = false)
    private String SongName ;

    @Column(nullable = false)
    private String Artist ;

    public MusicModel (int id,String SongName, String Artist) {
        this.id = id;
        this.SongName = SongName;
        this.Artist = Artist;
    }

    public Integer getId() {
        return id;
    }

    public String getSongname() {
        return SongName;
    }

    public String getArtist() {
        return Artist;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setSongname(String SongName) {
        this.SongName = SongName;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

}
