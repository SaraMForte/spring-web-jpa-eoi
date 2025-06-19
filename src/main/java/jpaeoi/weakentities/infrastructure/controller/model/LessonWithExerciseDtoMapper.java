package jpaeoi.weakentities.infrastructure.controller.model;

import jpaeoi.weakentities.domain.Exercise;
import jpaeoi.weakentities.domain.Lesson;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonWithExerciseDtoMapper {

    public LessonWithExerciseDto fromDomain(Lesson lesson, List<Exercise> exercise) {
        LessonWithExerciseDto dto = new LessonWithExerciseDto();
        dto.setIdLesson(lesson.getId());
        dto.setTitle(lesson.getTitle());
        dto.setStatements(exercise.stream()
                .map(Exercise::getStatement)
                .toList()
        );

        return new LessonWithExerciseDto();
    }
}
