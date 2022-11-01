module com.example.teamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.teamproject to javafx.fxml;
    exports com.example.teamproject;
}