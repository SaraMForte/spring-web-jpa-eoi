package jpaeoi.application;

import jpaeoi.application.model.CategorySellsCount;
import jpaeoi.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    public List<Employee> findEmployeeOfOffices() {
        return employeeRepository.findEmployeeOfOffices();
    }

    public Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee() {
        return employeeRepository.findAllCategorySellsCountByEmployee();
    }
}
