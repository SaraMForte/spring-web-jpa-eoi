package jpaeoi.weakentities.application;

import jpaeoi.weakentities.domain.Exercise;

import java.util.List;
import java.util.Optional;

public class ExerciseService {

    ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAllExercises();
    }

    public Optional<Exercise> findExerciseById(int idExercise, int idLesson) {
        return exerciseRepository.findExerciseById(idExercise, idLesson);
    }
}
