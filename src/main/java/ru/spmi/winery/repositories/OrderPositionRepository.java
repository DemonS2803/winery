package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.OrderPosition;
import ru.spmi.winery.entities.embedded.OrderBatchId;

@Repository
public interface OrderPositionRepository extends JpaRepository<OrderPosition, OrderBatchId> {
}
