package jpaeoi.gandening.infrastructure.config;

import jpaeoi.gandening.application.EmployeeService;
import jpaeoi.gandening.infrastructure.persistence.JpaEmployeeRepository;
import org.springframework.context.annotation.Bean;

public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeService(JpaEmployeeRepository jpaEmployeeRepository) {
        return new EmployeeService(jpaEmployeeRepository);
    }
}
