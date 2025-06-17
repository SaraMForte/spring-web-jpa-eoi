package jpaeoi.weakentities.infrastructure.persistence;

import jpaeoi.weakentities.application.LessonRepository;
import jpaeoi.weakentities.domain.Lesson;
import jpaeoi.weakentities.infrastructure.persistence.model.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaLessonRepository extends JpaRepository<LessonEntity, Integer>, LessonRepository {

    @Override
    default Optional<Lesson> findLessonById(int id) {
        return findById(id).map(LessonEntity::toDomain);
    }

    @Override
    default List<Lesson> findAllLesson() {
        return findAll().stream()
                .map(LessonEntity::toDomain)
                .toList();
    }
}
