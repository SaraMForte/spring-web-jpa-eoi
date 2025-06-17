package jpaeoi.weakentities.infrastructure.config;

import jpaeoi.weakentities.application.LessonService;
import jpaeoi.weakentities.infrastructure.persistence.JpaLessonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LessonConfiguration {

    @Bean
    public LessonService lessonService(JpaLessonRepository jpaLessonRepository) {
        return new LessonService(jpaLessonRepository);
    }
}
