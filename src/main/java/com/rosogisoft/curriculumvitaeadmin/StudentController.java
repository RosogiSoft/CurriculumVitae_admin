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
        //setChekboxValues();
        //setViewData(DataContainer.getSelectedStudent()); //Заполнение студента значениями
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
        nameTextField.setText(person.getName()!= null ? person.getName() : "Нет информации");
        birthDateTextField.setText(person.getDateOfBirth()!= null ? person.getDateOfBirth() : "Нет информации");
        phoneNumberTextField.setText(person.getPhoneNumber()!= null ? person.getPhoneNumber() : "Нет информации");
        mailTextField.setText(person.getMailAddress()!= null ? person.getMailAddress() : "Нет информации");
        groupNumberTextField.setText(person.getGroupNumber()!= null ? person.getGroupNumber() : "Нет информации");
        specialityChoiceBox.setValue(person.getSpeciality()!= null ? person.getSpeciality() : "Нет информации");
        //Инициализация текста для списка компетенций
        /*
        additionalCompetencyTextArea.setText(person.getAdditionalCompetencies()!= null ? person.getAdditionalCompetencies() : "Нет информации");
        additionalInfoTextArea.setText(person.getAdditionalInfo()!= null ? person.getAdditionalInfo() : "Нет информации");
        foreignLanguageChoiceBox.setValue(person.getForeignLanguage()!= null ? person.getForeignLanguage() : "Нет информации");
        driverLicenceChoiceBox.setValue(person.getDriverLicense()!= null ? person.getDriverLicense() : "Нет информации");
        socialNetworkTextArea.setText(person.getSocialNetwork()!= null ? person.getSocialNetwork() : "Нет информации");
        establishmentTextField.setText(person.getEstablishment()!= null ? person.getEstablishment() : "Нет информации");
        facultyTextField.setText(person.getFaculty()!= null ? person.getFaculty() : "Нет информации");
        formOfStudyChoiceBox.setValue(person.getFormOfStudy()!= null ? person.getFormOfStudy() : "Нет информации");
        yearOfEndingChoiceBox.setValue(person.getYearOfEnding()!= null ? person.getYearOfEnding() : "Нет информации");
        cityTextField.setText(person.getCity()!= null ? person.getCity() : "Нет информации");
        */
    }

    public void cancel(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
    }
}
