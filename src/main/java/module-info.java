module com.example.teamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.teamproject to javafx.fxml;
    exports com.example.teamproject;
}