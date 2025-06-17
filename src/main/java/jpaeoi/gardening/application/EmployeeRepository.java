package jpaeoi.gandening.application;

import jpaeoi.gandening.application.model.CategorySellsCount;
import jpaeoi.gandening.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findEmployeeById(Integer id);

    List<Employee> findEmployeeOfOffices();

    Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee();
}
