package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Lesson;
import jpaeoi.weakentities.domain.LessonExercises;
import jpaeoi.weakentities.domain.LessonUsers;

import java.util.List;
import java.util.Optional;

public interface LessonRepository {

    Optional<Lesson> findLessonById(int id);

    List<Lesson> findAllLesson();

    List<LessonExercises> findAllLessonExercises();

    Optional<LessonExercises> findLessonExercisesByLessonId(int lessonId);

    List<LessonUsers> findAllLessonUsers();

    Optional<LessonUsers> findLessonUsersByLessonId(int lessonId);
}
