module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    exports com.example.aventurasdemarcoyluis.characters;
    opens com.example.aventurasdemarcoyluis.characters to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.items;
    opens com.example.aventurasdemarcoyluis.items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.characters.players;
    opens com.example.aventurasdemarcoyluis.characters.players to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.characters.enemies;
    opens com.example.aventurasdemarcoyluis.characters.enemies to javafx.fxml;
}