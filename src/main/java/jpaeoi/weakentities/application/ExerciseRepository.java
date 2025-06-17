package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {

    List<Exercise> findAllExercises();

    Optional<Exercise> findExerciseById(int idExercise, int idLesson);

}
