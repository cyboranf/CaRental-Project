package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.carental.domain.RentedCar;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentedCarRepository extends JpaRepository<RentedCar,Long> {
    RentedCar save(RentedCar rentedCar);
    
    List<RentedCar> findAllByUserId(Long id);
    
    void deleteByUserId(Long id);
    
    void deleteByCarId(Long id);
}
