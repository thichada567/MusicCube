package gogo.mission3.Repository;


import gogo.mission3.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Select ALL method
    public List<MusicModel> selectAll() {
        return jdbcTemplate.query("SELECT * FROM music.musiclist", new BeanPropertyRowMapper<>(MusicModel.class));
    }

    /*Getting a specific item by item id from table*/
    public MusicModel getMusic(int id){
        String query = "SELECT * FROM music.musiclist WHERE id = ?";
        MusicModel musicone = jdbcTemplate.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(MusicModel.class));

        return musicone;
    }

    /*Adding an instrument into database table*/
    public String addMusic(MusicModel musicModel) {
        String query = "INSERT INTO music.musiclist(id, SongName, Artist)" + "VALUES (?,?,?)";
        jdbcTemplate.update(query,
                musicModel.getId(),
                musicModel.getSongname(),
                musicModel.getArtist());
        return query;
    }
    /*Updating a music into database table*/
    public void updateMusic(int id,MusicModel musicModel){
        String query = "UPDATE music.musiclist SET" + " SongName = ?,Artist = ?"+" WHERE id = ?";
        jdbcTemplate.update(query,
                musicModel.getId(),
                musicModel.getSongname(),
                musicModel.getArtist());
    }
    /*delete a music from database*/
    public int deleteMusic(int id){
        String query = "DELETE FROM music.musiclist WHERE id =?";
        return jdbcTemplate.update(query,id);
    }

}
