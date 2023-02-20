package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;

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
        setChoiceBoxValues();
        updateTable();
    }
    public void edit(ActionEvent actionEvent) throws IOException {
        DataContainer.setSelectedStudent(tableView.getSelectionModel().getSelectedItem());
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle("Curriculum Vitae admin");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(tableView.getScene().getWindow());
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
        courseFilterFileld.setItems(DataContainer.getCourses());
        groupNumberFilterField.setItems(DataContainer.getGroups());
        specialtyFilterFiled.setItems(DataContainer.getSpecialties());
    }

    private void updateTable(){
        FilteredList<Person> studs = new FilteredList<>(FXCollections.observableArrayList());;
        studs.clear();
        studs = new FilteredList<>(DataContainer.getStudents());
        Predicate<Person> nameCheck = name -> name.getName().contains(!Objects.equals(nameTextFiled.getText(), "") ? nameTextFiled.getText() : "");
        Predicate<Person> courceCheck = cource -> cource.getGroupNumber().startsWith(!Objects.equals(courseFilterFileld.getValue(), "") ? courseFilterFileld.getValue().toString() : "");
        Predicate<Person> groupCheck = group -> group.getGroupNumber().contains(!Objects.equals(groupNumberFilterField.getValue(), "") ? groupNumberFilterField.getValue().toString() : "");
        Predicate<Person> specialityCheck = speciality -> speciality.getSpeciality().equals(!Objects.equals(specialtyFilterFiled.getValue(), "") ? specialtyFilterFiled.getValue().toString() : "");
        Predicate<Person> filter = nameCheck;

        if (!nameTextFiled.getText().equals("")){
           filter = filter.and(nameCheck);
            System.out.println("Фильтр по имени добавлен!");
        }
        if (courseFilterFileld.getValue() != null && !courseFilterFileld.getValue().equals("")){
            filter = filter.and(courceCheck);
            System.out.println("Фильтр по курсу добавлен!");
        }
        if (groupNumberFilterField.getValue() != null && !groupNumberFilterField.getValue().equals("")){
            filter = filter.and(groupCheck);
            System.out.println("Фильтр по группе добавлен!");
        }
        if (specialtyFilterFiled.getValue() != null && !specialtyFilterFiled.getValue().equals("")){
            filter = filter.and(specialityCheck);
            System.out.println("Фильтр по специальности добавлен!");
        }
        studs.setPredicate(filter);

        nameColum.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        specialtyColum.setCellValueFactory(new PropertyValueFactory<Person, String>("speciality"));
        dateOfBirthColum.setCellValueFactory(new PropertyValueFactory<Person, String>("dateOfBirth"));
        groupNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("groupNumber"));
        phoneNumberColum.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        tableView.setItems(studs);
        System.out.println("_______________________");
        System.out.println("Поиск выполнен!");
    }
    public void keyPressedNameTextField(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            updateTable();
        }
    }

    //TODO: В последствии нужно будет добавить обработчики для всех остальных кнопок в MenuBar
    //Кнопка в MenuBar
    public void updateStudents(ActionEvent actionEvent) {
        DataBaseConnection.getData();
        DataContainer.setStudents(DataBaseConnection.getData());
        updateTable();
    }

    public void changeData(ActionEvent actionEvent) {

    }

    public void aboutProgram(ActionEvent actionEvent) {

    }

    public void contacts(ActionEvent actionEvent) {

    }
}