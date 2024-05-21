package hu.naplogui.view;

import hu.naplogui.model.Note;
import javafx.scene.Camera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.security.auth.callback.TextInputCallback;

public class ViewContent extends Stage {
    public ViewContent(Note noteToView) {
        VBox root = new VBox();
        Text title = new Text(noteToView.getTitle());
        Text category = new Text(noteToView.getCategory());
        Text content = new Text(noteToView.getContent());
        Text createdAt = new Text(noteToView.getCreatedAt());
        Button backBtn = new Button("Vissza");
        root.getChildren().addAll(title, category, content, createdAt, backBtn);

        Scene scene = new Scene(root, 500,380);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Bejegyzés - " + noteToView.getTitle());
        stage.show();

        backBtn.setOnAction(e-> {
            stage.close();
        });

    }
}
