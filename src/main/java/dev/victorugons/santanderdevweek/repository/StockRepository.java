package dev.victorugons.santanderdevweek.repository;

import dev.victorugons.santanderdevweek.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {


    Optional<Stock> findByNameAndDate(String name, LocalDate date);
}
