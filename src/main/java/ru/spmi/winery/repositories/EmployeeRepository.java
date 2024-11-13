package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT employee_exists(?1, ?2)", nativeQuery = true)
    Boolean isEmployeeExists(String login, String password);

    Employee findByEmail(String email);
}
