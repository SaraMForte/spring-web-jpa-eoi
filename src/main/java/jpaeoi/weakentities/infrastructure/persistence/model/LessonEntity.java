package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.weakentities.domain.Lesson;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lessons", schema = "weak_entities")
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_lesson",
            schema = "weak_entities",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> users = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idLesson")
    private Set<ExerciseEntity> exercises = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public Set<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(Set<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

    public Lesson toDomain() {
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setTitle(title);
        return lesson;
    }
}
