package hu.naplogui.controller;

import hu.naplogui.dao.ConfigManager;
import hu.naplogui.dao.NoteDAO;
import hu.naplogui.dao.NoteDAOImpl;

public class NoteController {
    private NoteDAO dao;
    private static NoteController single_instance = null;

    private NoteController() {
        dao = NoteDAOImpl.getInstance(ConfigManager.getValue("db-kulcs"));
    }


}
