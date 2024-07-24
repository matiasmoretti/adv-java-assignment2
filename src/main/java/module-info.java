module com.example.apidemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.apidemo to javafx.fxml;
    exports com.example.apidemo;
}