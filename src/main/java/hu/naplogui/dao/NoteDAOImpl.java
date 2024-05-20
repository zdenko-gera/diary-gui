package hu.naplogui.dao;

import hu.naplogui.model.Note;

import java.util.List;

public class NoteDAOImpl implements NoteDAO {

    private static String CONN;
    private static NoteDAOImpl instance;

    private  NoteDAOImpl(String conn) {
        CONN = conn;
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static NoteDAOImpl getInstance(String connStr){
        if(instance == null){
            synchronized (NoteDAOImpl.class){
                if(instance == null){
                    instance = new NoteDAOImpl(connStr);
                }
            }
        }
        return instance;
    }

    private enum Query{
        INSERT("INSERT INTO note (title, category, content, created_at, user_id) VALUES(?,?,?,?,?);"),
        SELECT("SELECT * FROM note;"),
        FILTER("SELECT * FROM note WHERE category = ?;");

        private String command;

        Query(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }
    }

    @Override
    public boolean add(Note note) {
        return false;
    }

    @Override
    public List<Note> find(Note note) {
        return null;
    }
}
