package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OptionEntityId {

    @Column(name = "id")
    private int idOption;

    @Column(name = "id_exercise")
    private int idExercise;

    @Column(name = "id_lesson")
    private int idLesson;

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }
}
