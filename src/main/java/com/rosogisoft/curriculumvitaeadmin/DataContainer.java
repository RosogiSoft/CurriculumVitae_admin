package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {
    private static ObservableList<String> specialties = FXCollections.observableArrayList();
    private static ObservableList<Person> students = FXCollections.observableArrayList();
    private static ObservableList<String> courses = FXCollections.observableArrayList();
    private static ObservableList<String> groups = FXCollections.observableArrayList();

    public static void getData(){
        setSpecialties();
        setCourses();
        setGroups();
        setStudents();

    }

    //Setters
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
