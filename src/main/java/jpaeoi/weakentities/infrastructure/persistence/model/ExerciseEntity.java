package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.weakentities.domain.Exercise;

@Entity
@Table(name = "exercises", schema = "weak_entities")
public class ExerciseEntity {

    @EmbeddedId
    private ExerciseEntityId id;

    @MapsId("idLesson")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lesson", nullable = false)
    private LessonEntity idLesson;

    @Column(name = "statement")
    private String statement;

    public ExerciseEntityId getId() {
        return id;
    }

    public void setId(ExerciseEntityId id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Exercise toDomain() {
        Exercise exercise = new Exercise();
        exercise.setId(id.getId());
        exercise.setLesson(idLesson.toDomain());
        exercise.setStatement(statement);
        return exercise;
    }
}
