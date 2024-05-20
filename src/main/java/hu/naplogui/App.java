package hu.naplogui;

import hu.naplogui.controller.NoteController;
import hu.naplogui.dao.ConfigManager;
import hu.naplogui.model.Note;
import hu.naplogui.view.addNote;
import hu.naplogui.view.listNotes;
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
        MenuItem listNotesMI = new MenuItem("Jegyzeteim");
        MenuBar mainMenuBar = new MenuBar();
        noteMenu.getItems().addAll(addNoteMI, listNotesMI);
        mainMenuBar.getMenus().addAll(noteMenu/*,userMenu*/);

        addNoteMI.setOnAction(e-> {
            new addNote();
        });

        listNotesMI.setOnAction(e-> {
            new listNotes(NoteController.getInstance().find(new Note()));
        });

        root.getChildren().addAll(mainMenuBar, appTitle);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Napló projekt");
        stage.show();
        //System.out.println(ConfigManager.getValue("db.url"));
    }

    public static void main(String[] args) {
        launch();
    }

}