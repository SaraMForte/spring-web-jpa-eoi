package jpaeoi.weakentities.infrastructure.persistence;

import jpaeoi.weakentities.domain.Lesson;
import jpaeoi.weakentities.domain.LessonExercises;
import jpaeoi.weakentities.domain.LessonUsers;
import jpaeoi.weakentities.infrastructure.persistence.model.ExerciseEntity;
import jpaeoi.weakentities.infrastructure.persistence.model.LessonEntity;
import jpaeoi.weakentities.infrastructure.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface JpaLessonRepository extends JpaRepository<LessonEntity, Integer>, jpaeoi.weakentities.application.LessonRepository {

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

    @Override
    default List<LessonExercises> findAllLessonExercises() {
        return findAll().stream().map(lesson -> {
            LessonExercises le = new LessonExercises();
            le.setLesson(lesson.toDomain());
            le.setExercises(
                    lesson.getExercises()
                            .stream()
                            .map(ExerciseEntity::toDomain)
                            .collect(Collectors.toSet())
            );
            return le;
        }).toList();
    }

    @Override
    default Optional<LessonExercises> findLessonExercisesByLessonId(int lessonId) {
        return findById(lessonId).map(lesson -> {
            LessonExercises le = new LessonExercises();
            le.setLesson(lesson.toDomain());
            le.setExercises(
                    lesson.getExercises()
                            .stream()
                            .map(ExerciseEntity::toDomain)
                            .collect(Collectors.toSet())
            );
            return le;
        });
    }

    @Override
    default List<LessonUsers> findAllLessonUsers() {
        return findAll().stream().map(lesson -> {
            LessonUsers le = new LessonUsers();
            le.setLesson(lesson.toDomain());
            le.setUsers(
                    lesson.getUsers()
                            .stream()
                            .map(UserEntity::toDomain)
                            .collect(Collectors.toSet())
            );
            return le;
        }).toList();
    }

    @Override
    default Optional<LessonUsers> findLessonUsersByLessonId(int lessonId) {
        return findById(lessonId).map(lesson -> {
            LessonUsers le = new LessonUsers();
            le.setLesson(lesson.toDomain());
            le.setUsers(
                    lesson.getUsers()
                            .stream()
                            .map(UserEntity::toDomain)
                            .collect(Collectors.toSet())
            );
            return le;
        });
    }
}
