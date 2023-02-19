package com.rosogisoft.curriculumvitaeadmin;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    //В методе init мы выполняем все заборы значения из БД
    public void init(){
        DataBaseConnection.getConnectionData();
        notifyPreloader(new Preloader.ProgressNotification(0.1));
        System.out.println("Загрузка специальностей...");
        DataContainer.setSpecialties();
        notifyPreloader(new Preloader.ProgressNotification(0.2));
        System.out.println("Загрузка курсов...");
        DataContainer.setCourses();
        notifyPreloader(new Preloader.ProgressNotification(0.3));
        System.out.println("Загрузка групп...");
        DataContainer.setGroups();
        notifyPreloader(new Preloader.ProgressNotification(0.4));
        System.out.println("Загрузка иностранных языков...");
        DataContainer.setForeignLanguages();
        notifyPreloader(new Preloader.ProgressNotification(0.5));
        System.out.println("Загрузка водительских прав...");
        DataContainer.setDriverLicenses();
        notifyPreloader(new Preloader.ProgressNotification(0.6));
        System.out.println("Загрузка форм обучения...");
        DataContainer.setFormOfStudy();
        notifyPreloader(new Preloader.ProgressNotification(0.7));
        System.out.println("Загрузка годов окончания....");
        DataContainer.setYearOfEnding();
        notifyPreloader(new Preloader.ProgressNotification(0.8));
        System.out.println("Загрузка студентов");
        DataContainer.setStudents();
        notifyPreloader(new Preloader.ProgressNotification(0.9));
        System.out.println("Загрузка завершена!");
        notifyPreloader(new Preloader.ProgressNotification(1.0));

    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Curriculum Vitae Administrator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", InformationPreloader.class.getCanonicalName());
        Application.launch(HelloApplication.class, args);
        //launch();

    }
}