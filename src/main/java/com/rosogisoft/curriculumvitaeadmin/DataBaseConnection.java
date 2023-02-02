package com.rosogisoft.curriculumvitaeadmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {

    private static String url;
    private static String user;
    private static String password;
    private static Person person;
    private static ObservableList<Person> personData = FXCollections.observableArrayList();
    public static void getConnectionData(){
        FileInputStream fileInputStream;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream("src/main/resources/com/rosogisoft/curriculumvitaeadmin/connection.properties");
            properties.load(fileInputStream);

            url = properties.getProperty("db.host");
            user = properties.getProperty("db.login");
            password = properties.getProperty("db.password");

            System.out.println("Host: " + url);
            System.out.println("Login: " + user);
            System.out.println("Password: " + password);
        } catch (FileNotFoundException e) {
            System.err.println("Файл конфигурации отсутсвует!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке конфигурационного файла!");
            throw new RuntimeException(e);
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

//Можно вынести исполения запроса в отдельный метод и передвавать туда
//сам запрос и номер столбца откуда надо брать результат ->
//executeQuery(String sqlQuery, int columIndex)(){...}
//Большие таблицы не получиться заполнить

    public static ObservableList<String> getSpecialty(){
        ObservableList<String> array = FXCollections.observableArrayList();
        String sqlQ = "SELECT SPECIALTYNAME FROM Specialty_Code";
        try (Connection conn = connect()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlQ);
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            array.add("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ObservableList<String> getGroupNumber(){
        ObservableList<String> array = FXCollections.observableArrayList();
        String sqlQ = "SELECT DISTINCT GROUPNUMBER FROM Student";
        try (Connection conn = connect()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlQ);
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            array.add("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ObservableList<Person> getData(String course, String groupNumber, String specialty, String name) {
        String sqlQ = "SELECT " +
                "Student.ID," +
                "Student.STUDENTNAME," +
                "Student.DATEOFBIRTH," +
                "Student.GROUPNUMBER," +
                "Student.TELEPHONENUMBER," +
                "Specialty_Code.SPECIALTYNAME " +
                "FROM " +
                "Student AS Student " +
                "LEFT JOIN " +
                "Specialty_Code AS Specialty_Code " +
                "ON " +
                "Student.SPECIALTYCODE = Specialty_Code.SPECIALTYCODE " +
                "WHERE " +
                "Student.GROUPNUMBER LIKE '" + course + "%' AND " +
                "Specialty_Code.SPECIALTYNAME LIKE '" + specialty + "%' AND " +
                "Student.GROUPNUMBER LIKE '" + groupNumber + "%' AND " +
                "Student.STUDENTNAME LIKE '" + name + "%';";

        try (Connection conn = connect()) {
            Statement statement = conn.prepareStatement(sqlQ);
            ResultSet rs = statement.executeQuery(sqlQ);
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getString(1));
                person.setName(rs.getString(2));
                person.setDateOfBirth(rs.getString(3));
                person.setGroupNumber(rs.getString(4));
                person.setPhoneNumber(rs.getString(5));
                person.setSpeciality(rs.getString(6));
                personData.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personData;
    }
}
