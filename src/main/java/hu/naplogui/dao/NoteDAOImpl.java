package hu.naplogui.dao;

import hu.naplogui.model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteDAOImpl implements NoteDAO {

    private static String CONN;
    private static NoteDAOImpl instance;

    private NoteDAOImpl() {
        CONN = ConfigManager.getValue("db.url");
    }

    public static NoteDAOImpl getInstance(){
        if(instance == null){
            synchronized (NoteDAOImpl.class){
                if(instance == null){
                    instance = new NoteDAOImpl();
                }
            }
        }
        return instance;
    }

    private enum Query{
        INSERT("INSERT INTO note (title, category, content, created_at, user_id) VALUES(?,?,?,?,?);"),
        SELECT("SELECT * FROM note;"),
        FILTER("SELECT * FROM note WHERE category = ?;"),

        DELETE("DELETE FROM note WHERE created_at = ?;");

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

        try(Connection c = DriverManager.getConnection(CONN);
            PreparedStatement pst = c.prepareStatement(Query.INSERT.command, Statement.RETURN_GENERATED_KEYS))
        {
            pst.setString(1,note.getTitle());
            pst.setString(2, note.getCategory());
            pst.setString(3, note.getContent());
            pst.setString(4, note.getCreatedAt());
            pst.setInt(5, note.getUserID());

            int affectedRows = pst.executeUpdate();

            return affectedRows == 1;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Note> find(Note filter) {

        List<Note> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(CONN);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(Query.SELECT.command))
        {
            while(rs.next()){
                Note note = new Note();
                note.setTitle(rs.getString("title"));
                note.setCategory(rs.getString("category"));
                note.setContent(rs.getString("content"));
                note.setCreatedAt(rs.getString("created_at"));
                note.setUserID(rs.getInt("user_id"));

                result.add(note);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.stream()
                .filter(utazas -> filter.getTitle() == null || utazas.getTitle().equals(filter.getTitle()))
                .filter(utazas -> filter.getCategory() == null || utazas.getCategory().equals(filter.getCategory()))
                .filter(utazas -> filter.getContent() == null || utazas.getContent() == filter.getContent())
                .filter(utazas -> filter.getCreatedAt() == null || utazas.getCreatedAt() == filter.getCreatedAt())
                .filter(utazas -> filter.getUserID() == 0 || utazas.getUserID() == filter.getUserID())
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Note deleteNote) {
        try(Connection c = DriverManager.getConnection(CONN);
            PreparedStatement pst = c.prepareStatement(Query.DELETE.command, Statement.RETURN_GENERATED_KEYS))
        {
            pst.setString(1, deleteNote.getCreatedAt());

            int affectedRows = pst.executeUpdate();

            return affectedRows == 1;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
