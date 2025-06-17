package jpaeoi.gardening.infrastructure.persistence;

import jpaeoi.gardening.application.EmployeeRepository;
import jpaeoi.gardening.application.model.CategorySellsCount;
import jpaeoi.gardening.domain.Employee;
import jpaeoi.gardening.infrastructure.persistence.model.EmpleadoJpa;
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
