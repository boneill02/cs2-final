module com.example.cs2final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs2final to javafx.fxml;
    exports com.example.cs2final;
}