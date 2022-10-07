package pl.project.carental.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.carental.domain.RentedCar;
import pl.project.carental.repository.RentedCarRepository;

import java.util.List;

@Service
@Transactional
public class RentedCarService {
    private final RentedCarRepository rentedCarRepository;

    public RentedCarService(RentedCarRepository rentedCarRepository) {
        this.rentedCarRepository = rentedCarRepository;
    }

    public RentedCar saveRentedCar(RentedCar rentedCar){
        rentedCarRepository.save(rentedCar);
        return rentedCar;
    }

    public List<RentedCar> findAllByUserId(Long id){
        return rentedCarRepository.findAllByUserId(id);
    }

    public void delete(Long carId){
        rentedCarRepository.deleteByCarId(carId);
    }

    public void deleteByUserId(Long userId){
        rentedCarRepository.deleteByUserId(userId);
    }
}
