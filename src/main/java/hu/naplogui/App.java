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
import java.util.Random;


/**
 * JavaFX App
 */
public class App extends Application {

    public String[] quotes = {
            "\"Nagyon kevés kell a boldog élethez; mindez benned van, abban, ahogy gondolkodsz.\"\nMarcus Aurelius",
            "\"Bármilyen rossznak tűnjön is egy-egy helyzet, sosem tudhatjuk igazán, mi sül ki belőle.\"\nJames Norbury",
            "\"Minden sötétebb és rémesebb lesz, mielőtt minden jóra fordul.\"\nFredrik Backman",
            "\"Szerintem mindig félig tele a pohár, és akkora, hogy abba pont bele lehet fulladni.\"\nFredrik Backman",
            "\"Megtanulni pozitívabban gondolkodni olyan, mint amikor idegen nyelvet tanulunk: ha egy új nyelvet tanulsz, attól még nem felejted el az anyanyelvedet.\"\nRuss Harris"
    };

    @Override
    public void start(Stage stage) {
        Random random = new Random();
        int randIndex = random.nextInt(5);
        VBox root = new VBox();
        var appTitle = new Label(quotes[randIndex]);

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
        var scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Napló projekt");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}