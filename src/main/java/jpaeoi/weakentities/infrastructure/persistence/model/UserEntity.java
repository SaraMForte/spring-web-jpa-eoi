package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.weakentities.domain.User;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "weak_entities")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "user_lesson",
            schema = "weak_entities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private Set<LessonEntity> lessons = new LinkedHashSet<>();

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(Set<LessonEntity> lessons) {
        this.lessons = lessons;
    }

    public User toDomain() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
}
