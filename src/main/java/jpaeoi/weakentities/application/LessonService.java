package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Lesson;
import jpaeoi.weakentities.domain.LessonExercises;
import jpaeoi.weakentities.domain.LessonUsers;

import java.util.List;
import java.util.Optional;

public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findAllLesson() {
        return lessonRepository.findAllLesson();
    }

    public Optional<Lesson> findLessonById(int id) {
        return lessonRepository.findLessonById(id);
    }

    public List<LessonExercises> findAllLessonExercises() {
        return lessonRepository.findAllLessonExercises();
    }

    public Optional<LessonExercises> findLessonExercisesByLessonId(int id) {
        return lessonRepository.findLessonExercisesByLessonId(id);
    }

    public List<LessonUsers> findAllLessonUsers() {
        return lessonRepository.findAllLessonUsers();
    }

    public Optional<LessonUsers> findLessonUsersByLessonId(int lessonId) {
        return lessonRepository.findLessonUsersByLessonId(lessonId);
    }
}
