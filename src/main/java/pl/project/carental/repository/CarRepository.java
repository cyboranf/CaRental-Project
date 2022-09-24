package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.User;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car save(Car car);

    Car saveAndFlush(Car car);

    Optional<Car> findAllById(Long id);

    void deleteById(Long id);
}
