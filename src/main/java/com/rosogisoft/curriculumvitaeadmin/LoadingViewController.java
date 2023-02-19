package com.rosogisoft.curriculumvitaeadmin;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;



public class LoadingViewController {

    public ImageView collegeLogo; //Догрузить в проект логотип колледжа и\или сделать в настройках через .properties
    public ImageView rosogisoftLogo; //Догрузить в проект логотип колледжа и\или сделать в настройках через .properties
    public ProgressBar progressBar;
    public Label progressIndicator;
    public Label errorField;

    public static ProgressBar progressBarS;
    public static Label progressIndicatorS;
    public static Label errorFieldS;

    public void initialize(){
        progressBarS = progressBar;
        progressIndicatorS = progressIndicator;
        errorFieldS = errorField;
    }
}
