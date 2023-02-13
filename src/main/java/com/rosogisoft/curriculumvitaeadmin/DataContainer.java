package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {
    private static ObservableList<String> specialties = FXCollections.observableArrayList();
    private static ObservableList<Person> students = FXCollections.observableArrayList();
    private static ObservableList<String> courses = FXCollections.observableArrayList();
    private static ObservableList<String> groups = FXCollections.observableArrayList();
    private static ObservableList<String> formOfStudys = FXCollections.observableArrayList();
    private static ObservableList<String> yearOfEndings = FXCollections.observableArrayList();
    private static ObservableList<String> foreignLanguages = FXCollections.observableArrayList();
    private static ObservableList<String> driverLicenses = FXCollections.observableArrayList();

    public static void getData(){
        setSpecialties();
        setCourses();
        setGroups();
        setStudents();
        setForeignLanguages();
        setDriverLicenses();
        setFormOfStudy();
        setYearOfEnding();
    }

    //Setters
    public static void setForeignLanguages() {
        foreignLanguages = DataBaseConnection.getForeignLanguages();
    }
    public static void setDriverLicenses() {
        driverLicenses = DataBaseConnection.getDriverLicenses();
    }
    public static void setFormOfStudy() {
        formOfStudys = DataBaseConnection.getFormOfStudy();
    }
    public static void setYearOfEnding() {
        yearOfEndings = DataBaseConnection.getYearOfEnding();
    }
    public static void setSpecialties() {
        specialties = DataBaseConnection.getSpecialty();
    }
    public static void setStudents() {
        students = DataBaseConnection.getData();
        for (Person person : students){
            person.showInfo();
        }
    }
    public static void setCourses() {
        courses = FXCollections.observableArrayList(
                new String(""),
                new String("1"),
                new String("2"),
                new String("3"),
                new String("4"),
                new String("5")

        );
    }
    public static void setGroups() {
        groups = DataBaseConnection.getGroupNumber();
    }

    //Getters
    public static ObservableList<String> getForeignLanguages() {
        return foreignLanguages;
    }
    public static ObservableList<String> getDriverLicenses() {
        return driverLicenses;
    }
    public static ObservableList<String> getFormOfStudy() {
        return formOfStudys;
    }
    public static ObservableList<String> getYearOfEnding() {
        return yearOfEndings;
    }
    public static ObservableList<String> getSpecialties() {
        return specialties;
    }
    public static ObservableList<Person> getStudents() {
        return students;
    }
    public static ObservableList<String> getCourses() {
        return courses;
    }
    public static ObservableList<String> getGroups() {
        return groups;
    }





}
