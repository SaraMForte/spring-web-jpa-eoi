package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.weakentities.domain.Lesson;

@Entity
@Table(name = "lessons", schema = "weak_entities")
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson toDomain() {
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setTitle(title);
        return lesson;
    }
}
