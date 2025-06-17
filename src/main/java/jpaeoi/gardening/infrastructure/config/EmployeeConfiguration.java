package jpaeoi.gardening.infrastructure.config;

import jpaeoi.gardening.application.EmployeeService;
import jpaeoi.gardening.infrastructure.persistence.JpaEmployeeRepository;
import org.springframework.context.annotation.Bean;

public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeService(JpaEmployeeRepository jpaEmployeeRepository) {
        return new EmployeeService(jpaEmployeeRepository);
    }
}
