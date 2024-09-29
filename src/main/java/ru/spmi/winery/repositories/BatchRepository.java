package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
}
