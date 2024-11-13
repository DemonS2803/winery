package ru.spmi.winery.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT customer_exists(?1, ?2)", nativeQuery = true)
    Boolean isCustomerExists(String login, String password);

    Customer findByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);
}
