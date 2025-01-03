package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



}
