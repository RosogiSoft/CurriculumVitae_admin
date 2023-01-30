module com.rosogisoft.curriculumvitaeadmin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires docx4j;
    requires java.xml.bind;


    opens com.rosogisoft.curriculumvitaeadmin to javafx.fxml;
    exports com.rosogisoft.curriculumvitaeadmin;
}