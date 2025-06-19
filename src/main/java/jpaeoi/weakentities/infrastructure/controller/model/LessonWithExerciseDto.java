package jpaeoi.weakentities.infrastructure.controller.model;

import java.util.ArrayList;
import java.util.List;

public class LessonWithExerciseDto {

    private int idLesson;

    private String title;

    private List<String> statements = new ArrayList<>();

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getStatements() {
        return statements;
    }

    public void setStatements(List<String> statements) {
        this.statements = statements;
    }
}
