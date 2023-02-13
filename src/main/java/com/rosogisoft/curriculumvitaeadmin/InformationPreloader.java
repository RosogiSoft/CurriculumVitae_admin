package com.rosogisoft.curriculumvitaeadmin;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InformationPreloader extends Preloader {
    private Stage preloaderStage;
    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loading_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Loading Curriculum Vitae admin");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
