package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Lesson;
import jpaeoi.weakentities.infrastructure.persistence.JpaLessonRepository;

import java.util.Optional;

public class LessonService {

    private final JpaLessonRepository jpaLessonRepository;

    public LessonService(JpaLessonRepository jpaLessonRepository) {
        this.jpaLessonRepository = jpaLessonRepository;
    }

    public Optional<Lesson> findLessonById(int id) {
        return jpaLessonRepository.findLessonById(id);
    }

}
