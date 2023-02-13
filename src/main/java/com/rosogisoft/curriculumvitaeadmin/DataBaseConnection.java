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


    public static ObservableList<Person> getData() {
        String sqlQ = "SELECT \n" +
                "`Student`.`ID`,\n" +
                "`Student`.`STUDENTNAME`,\n" +
                "`Student`.`DATEOFBIRTH`,\n" +
                "`Student`.`GROUPNUMBER`,\n" +
                "`Specialty_Code`.`SPECIALTYNAME`,\n" +
                "`Student`.`TELEPHONENUMBER`,\n" +
                "`Student`.`EMAILADDRESS`,\n" +
                "`Student_Additional_Info`.`ADDITIONALINFO`,\n" +
                "`Student_Additional_Info`.`FOREIGNLANGUAGE`,\n" +
                "`Student_Additional_Info`.`DRIVERLICENSE`,\n" +
                "`Student_Additional_Info`.`ADDITIONALCOMPETENCIES`,\n" +
                "`Student_Additional_Info`.`SOCIALNETWORK`,\n" +
                "`Student_Competencies`.`COMPETENCE1`,\n" +
                "`Student_Competencies`.`COMPETENCE2`,\n" +
                "`Student_Competencies`.`COMPETENCE3`,\n" +
                "`Student_Competencies`.`COMPETENCE4`,\n" +
                "`Student_Competencies`.`COMPETENCE5`,\n" +
                "`Student_Competencies`.`COMPETENCE6`,\n" +
                "`Student_Competencies`.`COMPETENCE7`,\n" +
                "`Student_Competencies`.`COMPETENCE8`,\n" +
                "`Student_Competencies`.`COMPETENCE9`,\n" +
                "`Student_Competencies`.`COMPETENCE10`,\n" +
                "`Student_Competencies`.`COMPETENCE11`,\n" +
                "`Student_Competencies`.`COMPETENCE12`,\n" +
                "`Student_Competencies`.`COMPETENCE13`,\n" +
                "`Student_Competencies`.`COMPETENCE14`,\n" +
                "`Student_Competencies`.`COMPETENCE15`,\n" +
                "`Student_Soft_Skills`.`FIRSTSOFTSKILL`,\n" +
                "`Student_Soft_Skills`.`SECONDSOFTSKILL`,\n" +
                "`Student_Soft_Skills`.`THIRDSOFTSKILL`,\n" +
                "`Student_Soft_Skills`.`FOURTHOFTSKILL`,\n" +
                "`Student_Soft_Skills`.`FIVETHSOFTSKILL`,\n" +
                "`Student_Education`.`ESTABLISHMENT`,\n" +
                "`Student_Education`.`FACULTY`,\n" +
                "`Student_Education`.`FORMOFSTUDY`,\n" +
                "`Student_Education`.`YEAROFENDING`,\n" +
                "`Student_Education`.`CITY`,\n" +
                "`Student_Photo`.`PHOTO`\n" +
                "FROM  Student\n" +
                "LEFT JOIN Student_Additional_Info\n" +
                "ON Student.ID = Student_Additional_Info.ID\n" +
                "LEFT JOIN Student_Competencies\n" +
                "ON Student.ID = Student_Competencies.ID\n" +
                "LEFT JOIN Student_Soft_Skills\n" +
                "ON Student.ID = Student_Soft_Skills.ID\n" +
                "LEFT JOIN Student_Photo\n" +
                "ON Student.ID = Student_Photo.ID\n" +
                "LEFT JOIN Student_Education\n" +
                "ON Student.ID = Student_Education.ID\n" +
                "LEFT JOIN Specialty_Code\n" +
                "ON Student.SPECIALTYCODE = Specialty_Code.SPECIALTYCODE;";
        ObservableList<Person> students = FXCollections.observableArrayList();
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
                person.setMailAddress(rs.getString(7));
                person.setAdditionalInfo(rs.getString(8));
                person.setForeignLanguage(rs.getString(9));
                person.setDriverLicense(rs.getString(10));
                person.setAdditionalCompetencies(rs.getString(11));
                person.setSocialNetwork(rs.getString(12));

                boolean[] competency = new boolean[15];
                for (int i = 13; i <= 27; i++){
                    competency[i-13] = rs.getBoolean(i);
                }
                person.setCompetency(competency);

                String[] softSkills = new String[6];
                for (int i = 28; i <= 33; i++){
                    softSkills[i - 28] = rs.getString(i);
                }
                person.setSoftSkills(softSkills);
                person.setFaculty(rs.getString(34));
                person.setFormOfStudy(rs.getString(35));
                person.setYearOfEnding(rs.getString(36));
                person.setCity(rs.getString(37));
                //person.setImage((rs.getBinaryStream(38).readAllBytes()); <- Решить вопрос с временным хранением файла
                person.showInfo();
                System.out.println("---------------------------------------------------------------------------");
                students.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ObservableList<String> getSpecialty(){
        String sqlQ = "SELECT SPECIALTYNAME FROM Specialty_Code";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> getGroupNumber(){
        String sqlQ = "SELECT DISTINCT GROUPNUMBER FROM Student";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> getForeignLanguages() {
        String sqlQ = "SELECT FOREIGNLANGUAGE FROM Foreign_Language;";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> getDriverLicenses(){
        String sqlQ = "SELECT DRIVERLICENSE FROM Driver_License;";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> getFormOfStudy() {
        String sqlQ = "SELECT FORMOFSTUDY FROM Form_Of_Study;";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> getYearOfEnding() {
        String sqlQ = "SELECT YEAROFENDING FROM Year_Of_Ending;";
        return executeQuery(sqlQ, 1);
    }
    public static ObservableList<String> executeQuery(String sqlQeury, int rowIndex){
        ObservableList<String> dataArray = FXCollections.observableArrayList();
        try (Connection conn = connect()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlQeury);
            while (rs.next()) {
                dataArray.add(rs.getString(rowIndex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataArray;
    }
}
