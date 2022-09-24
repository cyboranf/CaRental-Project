package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.domain.User;

import java.util.Optional;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails,Long> {
    CarDetails save(CarDetails carDetails);

    CarDetails saveAndFlush(CarDetails carDetails);

    Optional<CarDetails> findAllById(Long id);

    void deleteById(Long id);
}
