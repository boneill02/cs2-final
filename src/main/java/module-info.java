module com.example.cs2final {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.wit.comp1050.cs2final to javafx.fxml;
    exports edu.wit.comp1050.cs2final;
}