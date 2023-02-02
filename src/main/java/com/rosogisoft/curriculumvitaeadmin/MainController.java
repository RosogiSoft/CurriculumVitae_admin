package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    public TableView<Person> tableView;
    public TableColumn<Person, String> nameColum;
    public TableColumn<Person, String> dateOfBirthColum;
    public TableColumn<Person, String> groupNumberColum;
    public TableColumn<Person, String> phoneNumberColum;
    public TableColumn<Person, String> specialtyColum;
    public ChoiceBox courseFilterFileld;
    public ChoiceBox groupNumberFilterField;
    public ChoiceBox specialtyFilterFiled;
    public TextField nameTextFiled;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public void initialize(){
        DataBaseConnection.getConnectionData();
        setChoiceBoxValues();
    }
    //Функция для открытия страницы студента с последующей возможностью редактирования
    public void edit(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Curriculum Vitae admin");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(tableView.getScene().getWindow());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    //Функция для генерации резюме
    public void generate(ActionEvent actionEvent) {

    }

    public void updateButton(ActionEvent actionEvent) {
        updateTable();
    }

    private void setChoiceBoxValues() {
        ObservableList<String> course = FXCollections.observableArrayList(
                new String(""),
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
    /*
    Путь к оптимизации - делать запрос из БД ровно один раз при первичном обновлении таблицы
    После этого можно фильтровать данные не при помощи SQL запроса, а при помощи филтрации коллекции personData
    Первичный запрос можно сделать из метода initialize()
     */
    private void updateTable(){
        personData.clear();
        personData = DataBaseConnection.getData(
                courseFilterFileld.getValue() != null ? courseFilterFileld.getValue().toString() : "",
                groupNumberFilterField.getValue() != null ? groupNumberFilterField.getValue().toString() : "",
                specialtyFilterFiled.getValue() != null ? specialtyFilterFiled.getValue().toString() : "",
                nameTextFiled.getText() != null ? nameTextFiled.getText() : ""
        );

        nameColum.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        specialtyColum.setCellValueFactory(new PropertyValueFactory<Person, String>("speciality"));
        dateOfBirthColum.setCellValueFactory(new PropertyValueFactory<Person, String>("dateOfBirth"));
        groupNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("groupNumber"));
        phoneNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        tableView.setItems(personData);
    }

    public void keyReleasedOnNameTextFiled(KeyEvent keyEvent) {

    }

}