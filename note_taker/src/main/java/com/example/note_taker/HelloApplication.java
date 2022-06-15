package com.example.madjids_note_taker; // Started with Java Maven on IntelliJ, was finished in VSC.

import javafx.application.Application; // Imports libraries and dependencies needed to make the project run
import javafx.event.ActionEvent; //JPanel was switched to Javafx for this project as it was more lightweight
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox main_page = new VBox(5);
        stage.setTitle("Nevermore Notepad"); // Title of the canvas/stage
        Button _create = new Button("Press this button to create a new typing area."); // Creates new notesheet
        Button _settings = new Button("Settings");
        HBox _create_and_settings = new HBox(10);
        _create_and_settings.getChildren().addAll(_create, _settings);
        main_page.getChildren().add(_create_and_settings);
        Scene scene = new Scene(main_page, 1175, 800);
        _create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button _delete = new Button("Delete"); // Deletes the entire typing area
                TextArea _textarea = new TextArea("Insert your notes here...");
                Button _save = new Button("Save");
                HBox current_line = new HBox();
                current_line.getChildren().addAll(_textarea, _save, _delete);
                main_page.getChildren().add(current_line);
                _delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        main_page.getChildren().remove(current_line);
                    }
                });
                String path = "C://Users//Yukzo 2.0//Desktop//Notes//Notes.txt"; // Path needs to be modified at first
                                                                                 // by the end-user
                _save.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) { // Event Hander
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(path)); // Getting the path to the
                                                                                              // file (.txt format)

                            writer.write(_textarea.getText()); // Transfers user input into file
                            writer.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                _textarea.setEditable(true); // Allows user to edit text
                _textarea.setWrapText(true);

            }
        });

        stage.setScene(scene);
        stage.show();
        /*
         * stage.getIcons().add(
         * new Image(
         * <HelloApplication>.Application.getResourceAsStream( "icon.png" ))); Was meant
         * to have a custom Icon, issues caused by Operating System Compatibility forces
         * us to abandon this
         */
    }

    public static void main(String[] args) { // Runs the project
        launch();
    }
}
