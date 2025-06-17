package jpaeoi.weakentities.infrastructure.controller.model;

import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import jpaeoi.weakentities.application.LessonService;
import jpaeoi.weakentities.domain.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseDtoMapper implements DtoMapper<Exercise, ExerciseDto> {

    private final LessonService lessonService;

    public ExerciseDtoMapper(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    public Exercise toDomain(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setId(exerciseDto.getId());
        exercise.setLesson(lessonService.findLessonById(exerciseDto.getIdLesson()).orElseThrow());
        exercise.setStatement(exerciseDto.getStatement());
        return exercise;
    }

    @Override
    public ExerciseDto fromDomain(Exercise domain) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(domain.getId());
        exerciseDto.setIdLesson(domain.getLesson().getId());
        exerciseDto.setStatement(domain.getStatement());

        return exerciseDto;
    }

    @Override
    public Exercise emptyDomain() {
        return new Exercise();
    }

    @Override
    public ExerciseDto emptyDto() {
        return new ExerciseDto();
    }

}
