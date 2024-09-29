package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Vineyard;

@Repository
public interface VineyardRepository extends JpaRepository<Vineyard, Long> {
}
