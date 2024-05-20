module hu.naplogui {
    requires javafx.controls;
    requires org.xerial.sqlitejdbc;
    exports hu.naplogui;

    opens hu.naplogui.model to javafx.base;
}
