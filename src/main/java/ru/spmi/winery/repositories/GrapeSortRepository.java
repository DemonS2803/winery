package ru.spmi.winery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spmi.winery.entities.GrapeSort;

@Repository
public interface GrapeSortRepository extends JpaRepository<GrapeSort, Long> {
}
