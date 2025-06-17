package jpaeoi.weakentities.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExerciseEntityId {

    @Column(name = "id")
    private int id;

    @Column(name = "id_lesson")
    private int idLesson;

}
