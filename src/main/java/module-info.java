module com.example.zoomanagementapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoomanagementapplication to javafx.fxml;
    exports com.example.zoomanagementapplication;
}