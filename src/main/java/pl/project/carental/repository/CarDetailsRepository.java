package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carental.domain.CarDetails;

import java.util.Optional;

public interface CarDetailsRepository extends JpaRepository<CarDetails,Long> {

    Optional<CarDetails> findByPackageName(String name);
}
