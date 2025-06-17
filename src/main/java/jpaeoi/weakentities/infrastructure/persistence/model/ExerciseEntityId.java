package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExerciseEntityId {

    @Column(name = "id")
    private int id;

    @Column(name = "id_lesson")
    private int idLesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }
}
