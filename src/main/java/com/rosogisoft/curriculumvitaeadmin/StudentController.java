package com.rosogisoft.curriculumvitaeadmin;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
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
    public ProgressBar savingProgressBar;

    public void initialize(){
        setChekboxValues();
        setViewData(DataContainer.getSelectedStudent()); //Заполнение студента значениями
    }

    private void setChekboxValues(){
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);
        checkBoxes.add(checkBox5);
        checkBoxes.add(checkBox6);
        checkBoxes.add(checkBox7);
        checkBoxes.add(checkBox8);
        checkBoxes.add(checkBox9);
        checkBoxes.add(checkBox10);
        checkBoxes.add(checkBox11);
        checkBoxes.add(checkBox12);
        checkBoxes.add(checkBox13);
        checkBoxes.add(checkBox14);
        checkBoxes.add(checkBox15);
        specialityChoiceBox.setItems(DataContainer.getSpecialties());
        formOfStudyChoiceBox.setValue(DataContainer.getFormOfStudy());
        driverLicenceChoiceBox.setItems(DataContainer.getDriverLicenses());
        formOfStudyChoiceBox.setItems(DataContainer.getFormOfStudy());
        yearOfEndingChoiceBox.setItems(DataContainer.getYearOfEnding());
    }



    //TODO: Разбить метод на состовляюзие на каждый экран
    //TODO: Дописать заполнение для всех полей на view
    public void setViewData(Person person){
        //ВКЛАДКА "Личная информация"
        //avatarImageView.setImage(); <-- Пока нет логики хранения файла внутри Person
        nameTextField.setText(valueCheck(person.getName()));
        birthDateTextField.setText(valueCheck(person.getDateOfBirth()));
        phoneNumberTextField.setText(valueCheck(person.getPhoneNumber()));
        mailTextField.setText(valueCheck(person.getPhoneNumber()));
        groupNumberTextField.setText(valueCheck(person.getGroupNumber()));
        specialityChoiceBox.setValue(valueCheck(person.getSpeciality()));
        socialNetworkTextArea.setText(valueCheck(person.getSocialNetwork()));
        //ВКЛАДКА "Дополнительная информация"
        additionalInfoTextArea.setText(valueCheck(person.getAdditionalInfo()));
        additionalCompetencyTextArea.setText(valueCheck(person.getAdditionalCompetencies()));
        foreignLanguageChoiceBox.setValue(valueCheck(person.getForeignLanguage()));
        driverLicenceChoiceBox.setValue(valueCheck(person.getDriverLicense()));
        //ВКЛАДКА "Образование"
        establishmentTextField.setText(valueCheck(person.getFaculty()));
        facultyTextField.setText(valueCheck(person.getFaculty()));
        formOfStudyChoiceBox.setValue(valueCheck(person.getFormOfStudy()));
        yearOfEndingChoiceBox.setValue(valueCheck(person.getYearOfEnding()));
        cityTextField.setText(valueCheck(person.getCity()));


    }

    private String valueCheck(String value){
        if (value == null){
            return "Нет информаци";
        } else {
            return value;
        }
    }

    public void cancel(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    //TODO: Написать логику для сохранения данных
    //Во второй итерации оптимизации необходимо сделать проверку значений, т.е. если не изменено - то и схранять поле не нужно
    public void save(ActionEvent actionEvent) {
        savingProgressBar.setProgress(0.5);
        savingProgressBar.setVisible(true);
        DataContainer.getSelectedStudent().showInfo();
    }
}
