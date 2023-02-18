package com.rosogisoft.curriculumvitaeadmin;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class InformationPreloader extends Preloader {

    private Stage preloaderStage;
    Scene scene;
    Parent root;

    public InformationPreloader(){

    }

    public void initialize() throws IOException {
        System.out.println("Инициализация preloader!");

    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Инициализация start preloader");
        preloaderStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loading_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        preloaderStage.setTitle("Loading...");
        preloaderStage.setScene(scene);
        preloaderStage.setResizable(false);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();

    }

    @Override
    public void handleApplicationNotification(PreloaderNotification preloaderNotification) {//preloaderNotification <- double
        DataBaseConnection.getConnectionData();

        if (preloaderNotification instanceof ProgressNotification){
            LoadingViewController.progressBar.setProgress(((ProgressNotification) preloaderNotification).getProgress());
            //LoadingViewController.progressIndicator.setText("Загрузка: " + ((ProgressNotification) preloaderNotification).getProgress() + "...");
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        StateChangeNotification.Type type = stateChangeNotification.getType();
        switch (type){
            case BEFORE_START:
                System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }

    }



}
