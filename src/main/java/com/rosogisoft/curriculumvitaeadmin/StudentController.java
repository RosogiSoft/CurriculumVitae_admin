package com.rosogisoft.curriculumvitaeadmin;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    public ChoiceBox formOfStudyChoiceBox;
    public ChoiceBox yearOfEndingChoiceBox;
    public TextField cityTextField;
    //Дубликат экземпляра класса для сравнивания новых и старых значений
    private Person personInfo;
    public void initialize(){
        /*
        Нужно проинициализировать поля с выбором,такие как:
        Специальность, Иностранный язык, права, форма обучения, год окончания
        Так же добавить перечень выбранных компетенций
         */

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
