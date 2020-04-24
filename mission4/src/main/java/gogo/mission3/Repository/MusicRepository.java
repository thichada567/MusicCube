package gogo.mission3.Repository;


import gogo.mission3.Controller.MusicNotFoundAdvice;
import gogo.mission3.Exception.MusicNotFoundException;
import gogo.mission3.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        return jdbcTemplate.query("SELECT * FROM musiclist", new BeanPropertyRowMapper<>(MusicModel.class));
    }

    /*Getting a specific item by item id from table*/
    public MusicModel getMusic(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM musiclist WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(MusicModel.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    /*Adding an instrument into database table*/
    public String addMusic(MusicModel musicModel) {
        String query = "INSERT INTO musiclist(id, SongName, Artist)" + "VALUES (?,?,?)";
        jdbcTemplate.update(query,
                musicModel.getId(),
                musicModel.getSongname(),
                musicModel.getArtist());
        return query;
    }
    /*Updating a music into database table*/
    public void updateMusic(Integer id,MusicModel musicModel){
        String query = "UPDATE musiclist SET" + " SongName = ?,Artist = ?"+" WHERE id = ?";
        jdbcTemplate.update(query,
                musicModel.getSongname(),
                musicModel.getArtist(),
                musicModel.getId());
    }
    /*delete a music from database*/
    public int deleteMusic(Integer id){
        String query = "DELETE FROM musiclist WHERE id =?";
        return jdbcTemplate.update(query,id);
    }

}
