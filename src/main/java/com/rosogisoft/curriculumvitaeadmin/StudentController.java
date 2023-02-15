package com.rosogisoft.curriculumvitaeadmin;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    public ImageView avatarImageView;
    public TextField nameTextField;
    public TextField birthDateTextField;
    public TextField phoneNumberTextField;
    public TextField mailTextField;
    public TextField groupNumberTextField;
    public ChoiceBox specialityChoiceBox;
    public TextArea additionalInfoTextArea;
    public TextArea additionalCompetencyTextArea;
    public ChoiceBox foreignLanguageChoiceBox;
    public ChoiceBox driverLicenceChoiceBox;
    public TextArea socialNetworkTextArea;
    public TextField establishmentTextField;
    public TextField facultyTextField;
    public CheckBox checkBox1;
    public CheckBox checkBox2;
    public CheckBox checkBox3;
    public CheckBox checkBox4;
    public CheckBox checkBox5;
    public CheckBox checkBox6;
    public CheckBox checkBox7;
    public CheckBox checkBox8;
    public CheckBox checkBox9;
    public CheckBox checkBox10;
    public CheckBox checkBox11;
    public CheckBox checkBox12;
    public CheckBox checkBox13;
    public CheckBox checkBox14;
    public CheckBox checkBox15;
    public ChoiceBox formOfStudyChoiceBox;
    public ChoiceBox yearOfEndingChoiceBox;
    public TextField cityTextField;
    public List<CheckBox> checkBoxes = new ArrayList<>();

    public void initialize(){
        /*
        Нужно проинициализировать поля с выбором,такие как:
        Специальность, Иностранный язык, права, форма обучения, год окончания
        Так же добавить перечень выбранных компетенций
         */
        //Добавление в чекбоксов компетенций в массив
        setChekboxValues();
        for (CheckBox checkBox : checkBoxes){
            checkBoxes.add(checkBox);
        }
    }

    private void setChekboxValues(){
        specialityChoiceBox.setValue(DataContainer.getSpecialties());
        formOfStudyChoiceBox.setValue(DataContainer.getFormOfStudy());
        driverLicenceChoiceBox.setValue(DataContainer.getDriverLicenses());
        formOfStudyChoiceBox.setValue(DataContainer.getFormOfStudy());
        yearOfEndingChoiceBox.setValue(DataContainer.getYearOfEnding());
    }




    public void setViewData(Person person){
        //avatarImageView.setImage();
        nameTextField.setText(person.getName());
        birthDateTextField.setText(person.getDateOfBirth());
        phoneNumberTextField.setText(person.getPhoneNumber());
        mailTextField.setText(person.getMailAddress());
        groupNumberTextField.setText(person.getGroupNumber());
        specialityChoiceBox.setValue(person.getSpeciality());
        //Инициализация текста для списка компетенций
        additionalCompetencyTextArea.setText(person.getAdditionalCompetencies());
        additionalInfoTextArea.setText(person.getAdditionalInfo());
        foreignLanguageChoiceBox.setValue(person.getForeignLanguage());
        driverLicenceChoiceBox.setValue(person.getDriverLicense());
        socialNetworkTextArea.setText(person.getSocialNetwork());
        establishmentTextField.setText(person.getEstablishment());
        facultyTextField.setText(person.getFaculty());
        formOfStudyChoiceBox.setValue(person.getFormOfStudy());
        yearOfEndingChoiceBox.setValue(person.getYearOfEnding());
        cityTextField.setText(person.getCity());
    }

    public void cancel(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
    }
}
