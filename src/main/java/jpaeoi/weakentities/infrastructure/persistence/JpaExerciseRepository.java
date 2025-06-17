package jpaeoi.weakentities.infrastructure.persistence;

import jpaeoi.weakentities.application.ExerciseRepository;
import jpaeoi.weakentities.domain.Exercise;
import jpaeoi.weakentities.infrastructure.persistence.model.ExerciseEntity;
import jpaeoi.weakentities.infrastructure.persistence.model.ExerciseEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaExerciseRepository extends JpaRepository<ExerciseEntity, ExerciseEntityId>, ExerciseRepository {

    @Override
    default Optional<Exercise> findExerciseById(int idExercise, int idLesson) {
        ExerciseEntityId exerciseEntityId = new ExerciseEntityId();
        exerciseEntityId.setId(idExercise);
        exerciseEntityId.setIdLesson(idLesson);

        return findById(exerciseEntityId).map(ExerciseEntity::toDomain);
    }

    @Override
    default List<Exercise> findAllExercises() {
        return findAll().stream()
                .map(ExerciseEntity::toDomain)
                .toList();
    }
}
