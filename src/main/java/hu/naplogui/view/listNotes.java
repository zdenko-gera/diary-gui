package hu.naplogui.view;
import hu.naplogui.controller.NoteController;
import hu.naplogui.model.Note;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class listNotes extends Stage {
    public listNotes(List<Note> notes) {
        TableView<Note> root = new TableView<Note>();

        TableColumn<Note, String> titleColumn = new TableColumn<>("Cím");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Note, String> categoryColumn = new TableColumn<>("Kategória");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Note, String> createdAtColumn = new TableColumn<>("Dátum");
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<>("created_ad"));

        root.getColumns().addAll(titleColumn, categoryColumn, createdAtColumn);

        //List<Note> notes = NoteController.getInstance().find(new Note());
        root.setItems(FXCollections.observableArrayList(notes));



        Scene scene = new Scene(root, 700,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
