package hu.naplogui.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addNote extends Stage {
    public addNote() {
        GridPane root = new GridPane();
        Text title = new Text("Cím:");
        TextField titleInput = new TextField();
        root.add(title, 0,0);
        root.add(titleInput,1,0);

        root.addRow(2);
        Text category = new Text("Kategória:");
        ComboBox<String> categoryInput = new ComboBox<String>();

        ObservableList<String> categories = FXCollections.observableArrayList("Általános", "Álom");
        categoryInput.setItems(categories);
        categoryInput.setValue("Általános");
        root.add(category, 0,1);
        root.add(categoryInput,1,1);

        root.addRow(3);
        Text content = new Text("Bejegyzés:");
        TextArea contentInput = new TextArea();
        root.add(content, 0,2);
        root.add(contentInput,1,2);

        root.addRow(4);
        Button saveBtn = new Button("Mentés");
        Button cancelBtn = new Button("Mégse");
        root.add(saveBtn, 0,3);
        root.add(cancelBtn,1,3);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Új bejegyzés");
        stage.show();

        saveBtn.setOnAction(e-> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cím");
            alert.setHeaderText("Az ablak tartalom felső header része");
            alert.setContentText("Részletesebb leírás a header text alatt");

            alert.showAndWait();
        });

        cancelBtn.setOnAction(e-> {
            stage.close();
        });
    }
}
