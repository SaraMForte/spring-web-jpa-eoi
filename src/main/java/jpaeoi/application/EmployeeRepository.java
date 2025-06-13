package jpaeoi.application;

import jpaeoi.application.model.CategorySellsCount;
import jpaeoi.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> findEmployeeOfOffices();

    Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee();
}
