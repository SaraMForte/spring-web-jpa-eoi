package jpaeoi.infrastructure.config;

import jpaeoi.application.EmployeeService;
import jpaeoi.infrastructure.persistence.JpaEmployeeRepository;
import org.springframework.context.annotation.Bean;

public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeService(JpaEmployeeRepository jpaEmployeeRepository) {
        return new EmployeeService(jpaEmployeeRepository);
    }
}
