package com.rosogisoft.curriculumvitaeadmin;

import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class LoadingViewController {

    public ImageView collegeLogo; //Догрузить в проект логотип колледжа и\или сделать в настройках через .properties
    public ImageView rosogisoftLogo; //Догрузить в проект логотип колледжа и\или сделать в настройках через .properties
    public static ProgressBar progressBar;
    public static Label progressIndicator;
    public void initialize() throws IOException {

    }

    public void getValues() throws IOException {
        progressIndicator.setText("Загрузка специальностей...");
        DataContainer.setSpecialties();
        //notifyPreloader(new Preloader.ProgressNotification(0.1));
        progressBar.setProgress(0.1);
        progressIndicator.setText("Загрузка курсов...");
        DataContainer.setCourses();
        progressBar.setProgress(0.3);
        progressIndicator.setText("Загрузка групп...");
        DataContainer.setGroups();
        progressBar.setProgress(0.4);
        progressIndicator.setText("Загрузка студентов");
        DataContainer.setStudents();
        progressBar.setProgress(0.6);
        progressIndicator.setText("Загрузка иностранных языков...");
        DataContainer.setForeignLanguages();
        progressBar.setProgress(0.7);
        progressIndicator.setText("Загрузка водительских прав...");
        DataContainer.setDriverLicenses();
        progressBar.setProgress(0.8);
        progressIndicator.setText("Загрузка форм обучения...");
        DataContainer.setFormOfStudy();
        progressBar.setProgress(0.9);
        progressIndicator.setText("Загрузка годов окончания....");
        DataContainer.setYearOfEnding();
        progressBar.setProgress(1.0);
        progressIndicator.setText("Загрузка завершена!");

    }
}
