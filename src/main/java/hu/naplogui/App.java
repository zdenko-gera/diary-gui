package hu.naplogui;

import hu.naplogui.view.addNote;
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
        var appTitle = new Label("Napló projekt");

        Menu noteMenu = new Menu("Jegyzetek");
        //Menu userMenu = new Menu("Felhasználó");
        MenuItem addNoteMI = new MenuItem("Új jegyzet írása");
        MenuBar mainMenuBar = new MenuBar();
        noteMenu.getItems().add(addNoteMI);
        mainMenuBar.getMenus().addAll(noteMenu/*,userMenu*/);

        addNoteMI.setOnAction(e-> {
            new addNote();
        });

        root.getChildren().addAll(mainMenuBar, appTitle);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Napló projekt");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}