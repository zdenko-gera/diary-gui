package hu.naplogui.dao;

import hu.naplogui.model.Note;

import java.util.List;

public interface NoteDAO {
    boolean add(Note note);
    List<Note> find(Note note);
}
