package hu.naplogui.controller;

import hu.naplogui.dao.ConfigManager;
import hu.naplogui.dao.NoteDAO;
import hu.naplogui.dao.NoteDAOImpl;
import hu.naplogui.model.Note;

public class NoteController {
    private NoteDAO dao;
    private static NoteController single_instance = null;

    private NoteController() {
        dao = NoteDAOImpl.getInstance();
    }

    public static NoteController getInstance() {
        if(single_instance == null){
            //most nem probléma, de több szálon syncelni kell!
            single_instance = new NoteController();
        }
        return single_instance;
    }

    public boolean add(Note note) {
        return dao.add(note);
    }


}
