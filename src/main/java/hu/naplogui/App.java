package hu.naplogui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        var appTitle = new Label("#happydiary");

        Menu noteMenu = new Menu("Jegyzetek");
        //Menu userMenu = new Menu("Felhasználó");
        MenuItem mi = new MenuItem("avasas");
        MenuBar mainMenuBar = new MenuBar();
        noteMenu.getItems().add(mi);
        mainMenuBar.getMenus().addAll(noteMenu/*,userMenu*/);

        mi.setOnAction(e-> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cím");
            alert.setHeaderText("Az ablak tartalom felső header része");
            alert.setContentText("Részletesebb leírás a header text alatt");

            alert.showAndWait();
        });

        root.getChildren().addAll(mainMenuBar, appTitle);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Happy Diary");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}