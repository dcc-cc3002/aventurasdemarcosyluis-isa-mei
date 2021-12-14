module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    exports com.example.aventurasdemarcoyluis.model.characters;
    opens com.example.aventurasdemarcoyluis.model.characters to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.characters.players;
    opens com.example.aventurasdemarcoyluis.model.characters.players to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.characters.enemies;
    opens com.example.aventurasdemarcoyluis.model.characters.enemies to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.item;
    opens com.example.aventurasdemarcoyluis.model.item to javafx.fxml;
}