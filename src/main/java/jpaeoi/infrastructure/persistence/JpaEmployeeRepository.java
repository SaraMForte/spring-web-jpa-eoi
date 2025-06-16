package jpaeoi.infrastructure.persistence;

import jpaeoi.application.EmployeeRepository;
import jpaeoi.application.model.CategorySellsCount;
import jpaeoi.domain.Employee;
import jpaeoi.infrastructure.persistence.model.EmpleadoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmpleadoJpa, Integer>, EmployeeRepository {

    @Override
    default Optional<Employee> findEmployeeById(Integer id) {
        return findById(id).map(EmpleadoJpa::toDomain);
    }

    @Override
    default List<Employee> findEmployeeOfOffices() {
        return null;
    }

    @Override
    default Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee() {
        return null;
    }
}
