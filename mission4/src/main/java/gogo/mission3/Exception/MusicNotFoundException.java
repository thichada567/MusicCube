package gogo.mission3.Exception;



public class MusicNotFoundException extends RuntimeException {
        public MusicNotFoundException(Integer id) {
            super ("CANNOT FIND THIS MUSIC BY THIS ID = " + id + " !PLEASE HELP US ADD THIS MUSIC TO THE LIST!");
        }

}




