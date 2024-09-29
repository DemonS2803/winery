package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.Winery;

@Repository
public interface WineryRepository extends JpaRepository<Winery, Long> {
}
