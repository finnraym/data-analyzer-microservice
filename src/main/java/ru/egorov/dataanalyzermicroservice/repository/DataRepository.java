package ru.egorov.dataanalyzermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egorov.dataanalyzermicroservice.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
