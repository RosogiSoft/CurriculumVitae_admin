package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HelloController {


    public TableView<Person> tableView;
    public TableColumn<Person, String> nameColum;
    public TableColumn<Person, String> dateOfBirthColum;
    public TableColumn<Person, String> groupNumberColum;
    public TableColumn<Person, String> phoneNumberColum;
    public TableColumn<Person, String> specialtyColum;
    public ChoiceBox courseFilterFileld;
    public ChoiceBox groupNumberFilterField;
    public ChoiceBox specialtyFilterFiled;

    public void initialize(){
        DataBaseConnection.getConnectionData();
        setChoiceBoxValues();
    }

    private void setChoiceBoxValues() {
        ObservableList<String> course = FXCollections.observableArrayList(
                new String("1"),
                new String("2"),
                new String("3"),
                new String("4"),
                new String("5")

        );
        courseFilterFileld.setItems(course);
        groupNumberFilterField.setItems(DataBaseConnection.getGroupNumber());
        specialtyFilterFiled.setItems(DataBaseConnection.getSpecialty());
    }
    public void updateTable(ActionEvent actionEvent) {
        ObservableList<Person> personData =  DataBaseConnection.getData(
                courseFilterFileld.getValue() != null ? courseFilterFileld.getValue().toString() : "%",
                groupNumberFilterField.getValue() != null ? groupNumberFilterField.getValue().toString() : "%",
                specialtyFilterFiled.getValue() != null ? specialtyFilterFiled.getValue().toString() : "%"
        );
        nameColum.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        specialtyColum.setCellValueFactory(new PropertyValueFactory<Person, String>("speciality"));
        dateOfBirthColum.setCellValueFactory(new PropertyValueFactory<Person, String>("dateOfBirth"));
        groupNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("groupNumber"));
        phoneNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        tableView.setItems(personData);
    }

    public void edit(ActionEvent actionEvent) {

    }

    public void generate(ActionEvent actionEvent) {

    }
}