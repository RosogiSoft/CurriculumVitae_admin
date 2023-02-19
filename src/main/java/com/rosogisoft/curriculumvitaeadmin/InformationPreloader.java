package com.rosogisoft.curriculumvitaeadmin;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class InformationPreloader extends Preloader {

    private Stage preloaderStage;
    private Scene scene;

    public InformationPreloader(){

    }

    public void init() throws IOException {
        System.out.println("Инициализация init preloader!");
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loading_view.fxml")));
        scene = new Scene(root1);

    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Инициализация start preloader!");

        this.preloaderStage = stage;
        preloaderStage.setTitle("Loading...");
        preloaderStage.setScene(scene);
        preloaderStage.setResizable(false);
        //preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification preloaderNotification) {//preloaderNotification <- double
        if (preloaderNotification instanceof ProgressNotification){
            LoadingViewController.progressBarS.setProgress(((ProgressNotification) preloaderNotification).getProgress());
            LoadingViewController.progressIndicatorS.setText("Загрузка: " + (((ProgressNotification) preloaderNotification).getProgress() * 100) + "% ...");
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        StateChangeNotification.Type type = stateChangeNotification.getType();
        switch (type){
            case BEFORE_START:
                //System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }

    }



}
