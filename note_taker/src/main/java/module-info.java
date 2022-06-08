module com.example.madjids_note_taker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.madjids_note_taker to javafx.fxml;
    exports com.example.madjids_note_taker;
}