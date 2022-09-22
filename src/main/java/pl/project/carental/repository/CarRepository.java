package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.carental.domain.Car;

import java.awt.print.Pageable;
import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("select c from Car c")
    List<Car> findCars(Pageable pageable);

    @Query("select c from Car c where c.is_available=true")
    List<Car> findAvailableCars(Pageable pageable);
}
