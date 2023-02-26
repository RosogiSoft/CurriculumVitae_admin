package com.rosogisoft.curriculumvitaeadmin.generator.helper;

import com.rosogisoft.curriculumvitaeadmin.DataContainer;
import com.topologi.diffx.Main;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.JcEnumeration;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class GeneratorFilling {

    private final int HEADING_SIZE = 22 * 2;
    private final int MAIN_SIZE = 12 * 2;
    private final int BIG_SIZE = 16 * 2;

    public List<Object> addElementsFirstCol(Inline image) {
        List<Object> array = new ArrayList<>();
        array.add(ParagraphPreprocess.addImageToParagraph(image, JcEnumeration.CENTER));
        array.add(ParagraphPreprocess.addTextToParagraph("Образование", MAIN_SIZE, new BooleanDefaultTrue(),
                JcEnumeration.RIGHT));
        array.add(ParagraphPreprocess.addTextToParagraph("Дополнительное образование", MAIN_SIZE, new BooleanDefaultTrue(),
                JcEnumeration.RIGHT));
        array.add(ParagraphPreprocess.addTextToParagraph("Профессиональные навыки", MAIN_SIZE, new BooleanDefaultTrue(),
                JcEnumeration.RIGHT));
        array.add(ParagraphPreprocess.addTextToParagraph("Личные качества", MAIN_SIZE, new BooleanDefaultTrue(),
                JcEnumeration.RIGHT));
        array.add(ParagraphPreprocess.addTextToParagraph("Дополнительная информация", MAIN_SIZE, new BooleanDefaultTrue(),
                JcEnumeration.RIGHT));
        return array;
    }
    public List<Object> mainInfo() {
        ArrayList<Object> mainInfoArr = new ArrayList<>();
        mainInfoArr.add(ParagraphPreprocess.addTextToParagraph(DataContainer.getSelectedStudent().getName(),
                HEADING_SIZE, new BooleanDefaultTrue(), JcEnumeration.LEFT));
        mainInfoArr.add(ParagraphPreprocess.addTextToParagraph(
                String.format("Дата рождения: %s", DataContainer.getSelectedStudent().getDateOfBirth()), MAIN_SIZE
        ));
        mainInfoArr.add(ParagraphPreprocess.addTextToParagraph("Город: Москва", MAIN_SIZE));
        mainInfoArr.add(ParagraphPreprocess.addTextToParagraph(String.format("Телефон: %s",
                DataContainer.getSelectedStudent().getPhoneNumber()), MAIN_SIZE
        ));
        mainInfoArr.add(ParagraphPreprocess.addTextToParagraph(String.format(
                "E-mail: %s", DataContainer.getSelectedStudent().getMailAddress()), MAIN_SIZE));
        return mainInfoArr;
    }

    public List<Object> educationInfo() {
        ArrayList<Object> educationArrayList = new ArrayList<>();
        educationArrayList.add(ParagraphPreprocess.addTextToParagraphBold(
                DataContainer.getSelectedStudent().getSpeciality(), BIG_SIZE, new BooleanDefaultTrue(), JcEnumeration.RIGHT
        ));
        StringBuilder stringBuilder = new StringBuilder();
        educationArrayList.add(ParagraphPreprocess.addTextToParagraph(
                stringBuilder
                        .append(String.format("Дата окончания %s", DataContainer.getSelectedStudent().getYearOfEnding()))
                        .append(", ").append(String.format("Форма обучения: %s", DataContainer.getSelectedStudent().getFormOfStudy()))
                        .toString(), MAIN_SIZE
        ));
        StringBuilder stringBuilder1 = new StringBuilder();
        educationArrayList.add(ParagraphPreprocess.addTextToParagraph(
                stringBuilder1
                        .append(DataContainer.getSelectedStudent().getFaculty()).append(", ")
                        .append(DataContainer.getSelectedStudent().getEstablishment()).append(", ")
                        .append(DataContainer.getSelectedStudent().getCity())
                        .toString()
        ));
        return educationArrayList;
    }

    public List<Object> personalQualities() {
        ArrayList<Object> personalQualitiesArrayList = new ArrayList<>();
       /* personalQualitiesArrayList.add(ParagraphPreprocess.addTextToParagraph(
                " • Умею работать в команде и общаться с другими людьми.", MAIN_SIZE
        ));
        personalQualitiesArrayList.add(
                ParagraphPreprocess.addTextToParagraph(
                        " • Всегда ответственно выполняю поставленные задачи, " +
                                "  быстро учусь новому и постоянно развиваюсь как профессионал.", MAIN_SIZE
                ));
        personalQualitiesArrayList.add(
                ParagraphPreprocess.addTextToParagraph(
                        " • Всегда нацелен на результат и легко адаптируюсь к новым задачам.", MAIN_SIZE
                ));*/
        if (DataContainer.getSelectedStudent().getSoftSkills() != null){
            for (String initialString : DataContainer.getSelectedStudent().getSoftSkills()){
                personalQualitiesArrayList.add(ParagraphPreprocess
                        .addTextToParagraph(String.format(" • %s", initialString), MAIN_SIZE));
            }
        }
        return personalQualitiesArrayList;
    }

    public List<Object> additionalInformation() {
        ArrayList<Object> additionalInformation = new ArrayList<>();
        additionalInformation.add(
                ParagraphPreprocess.addTextToParagraph(
                        String.format(" • Водительское удостоверение: %s",
                                DataContainer.getSelectedStudent().getDriverLicense()), MAIN_SIZE
                ));
        additionalInformation.add(
                ParagraphPreprocess.addTextToParagraph(
                        String.format(" • Дополнительный язык: %s",
                                DataContainer.getSelectedStudent().getForeignLanguage()), MAIN_SIZE
                ));
        additionalInformation.add(
                ParagraphPreprocess.addTextToParagraph(
                        String.format(" • Дополнительная связь: %s ", DataContainer.getSelectedStudent().getSocialNetwork()),
                        MAIN_SIZE
                ));
        additionalInformation.add(
                ParagraphPreprocess.addTextToParagraph(
                        String.format(" • Дополнительная информация: %s",
                                DataContainer.getSelectedStudent().getAdditionalInfo()),
                        MAIN_SIZE
                ));
        return additionalInformation;
    }
}
