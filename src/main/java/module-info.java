module com.example.cs2final {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;


    opens edu.wit.comp1050.cs2final to javafx.fxml;
    exports edu.wit.comp1050.cs2final;
}