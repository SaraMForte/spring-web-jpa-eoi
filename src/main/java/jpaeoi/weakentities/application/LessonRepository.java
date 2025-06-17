package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonRepository {

    Optional<Lesson> findLessonById(int id);

    List<Lesson> findAllLesson();

}
