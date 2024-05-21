package hu.naplogui.view;
import hu.naplogui.controller.NoteController;
import hu.naplogui.model.Note;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class listNotes extends Stage {
    public listNotes(List<Note> notes) {
        VBox root = new VBox();
        GridPane gp = new GridPane();
        Text title = new Text("Cím:");
        TextField titleInput = new TextField();


        Text category = new Text("Kategória:");
        ComboBox<String> categoryInput = new ComboBox<String>();

        ObservableList<String> categories = FXCollections.observableArrayList("","Általános", "Álom");
        categoryInput.setItems(categories);

        Button filterBtn = new Button("Keresés");

        gp.add(title,0,0);
        gp.add(titleInput,1,0);
        gp.addRow(2);
        gp.add(category,0,1);
        gp.add(categoryInput,1,1);
        gp.addRow(3);
        gp.add(filterBtn,1,2);

        root.getChildren().add(gp);

        TableView<Note> table = new TableView<Note>();
        TableColumn<Note, String> titleColumn = new TableColumn<>("Cím");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Note, String> categoryColumn = new TableColumn<>("Kategória");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Note, String> createdAtColumn = new TableColumn<>("Dátum");
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<>("createdAt"));

        table.getColumns().addAll(titleColumn, categoryColumn, createdAtColumn);

        table.setItems(FXCollections.observableArrayList(notes));

        Scene scene = new Scene(root, 700,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Bejegyzéseim");
        stage.show();

        filterBtn.setOnAction(e->{
            List<Note> filtered = NoteController.getInstance().find(new Note(
                    titleInput.getText(),
                    categoryInput.getValue()
            ));
            table.setItems(FXCollections.observableArrayList(filtered));
        });

        root.getChildren().add(table);
        Button viewBtn = new Button("Megtekintés");

        Button deleteBtn = new Button("Törlés");
        root.getChildren().addAll(viewBtn, deleteBtn);

        viewBtn.setOnAction(e -> {
            Note selectedItem = table.getSelectionModel().getSelectedItem();
            if(selectedItem!= null) {
                new ViewContent(selectedItem);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nincs kijelölt bejegyzés");
                alert.setHeaderText("Válassz ki egy bejegyzést, amit meg szeretnél tekinteni!");
                alert.showAndWait();
            }


        });

        deleteBtn.setOnAction(e -> {
            Note selectedItem = table.getSelectionModel().getSelectedItem();
            if(selectedItem!= null) {
                if (NoteController.getInstance().delete(selectedItem)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sikeres törlés");
                    alert.setHeaderText("Sikeresen törölted a \"" + selectedItem.getTitle() + "\" című bejegyzést.");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nincs kijelölt bejegyzés");
                alert.setHeaderText("Válassz ki egy bejegyzést, amit törölni szeretnél!");
                alert.showAndWait();
            }
        });





        //List<Note> notes = NoteController.getInstance().find(new Note());



        Button closeBtn = new Button("Bezárás");
        root.getChildren().add(closeBtn);

        closeBtn.setOnAction(click -> {
            stage.close();
        });


    }
}
