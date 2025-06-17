package jpaeoi.weakentities.infrastructure.config;

import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import jpaeoi.shared.infrastructure.genericcontroller.GenericControllerConfig;
import jpaeoi.shared.infrastructure.generictable.GenericTable;
import jpaeoi.shared.infrastructure.generictable.GenericTableFactory;
import jpaeoi.weakentities.application.ExerciseService;
import jpaeoi.weakentities.domain.Exercise;
import jpaeoi.weakentities.infrastructure.controller.model.ExerciseDto;
import jpaeoi.weakentities.infrastructure.controller.model.ExerciseDtoMapper;
import jpaeoi.weakentities.infrastructure.persistence.JpaExerciseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ExerciseConfiguration {

    @Bean
    public ExerciseService exerciseService(JpaExerciseRepository jpaExerciseRepository) {
        return new ExerciseService(jpaExerciseRepository);
    }

    @Bean("exerciseControllerConfig")
    public GenericControllerConfig<Exercise, ExerciseDto> exerciseControllerConfig(
            ExerciseService exerciseService,
            JpaExerciseRepository jpaExerciseRepository,
            ExerciseDtoMapper mapper
    ) {
        return new GenericControllerConfig<Exercise, ExerciseDto>() {

            @Override
            public List<Exercise> findDomainAll() {
                return exerciseService.findAll();
            }

            @Override
            public Optional<Exercise> findDomainById(String id) {
                return Optional.empty();
            }

            @Override
            public void saveDomain(Exercise domain) {

            }

            @Override
            public void updateDomain(Exercise domain) {

            }

            @Override
            public void deleteDomainById(String id) {

            }

            @Override
            public DtoMapper<Exercise, ExerciseDto> mapper() {
                return mapper;
            }

            @Override
            public GenericTable getTable(List<ExerciseDto> entities) {
                return GenericTableFactory.create(entities, ExerciseDto.class);
            }
        };
    }

}
