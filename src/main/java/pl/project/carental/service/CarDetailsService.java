package pl.project.carental.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.repository.CarDetailsRepository;

import java.util.List;

@Service
@Transactional
public class CarDetailsService {
    private final CarDetailsRepository carDetailsRepository;

    public CarDetailsService(CarDetailsRepository carDetailsRepository) {
        this.carDetailsRepository = carDetailsRepository;
    }

    public CarDetails saveCar(CarDetails carDetails){
        carDetailsRepository.save(carDetails);
        return carDetails;
    }

    public List<CarDetails> findAll(){
        return carDetailsRepository.findAll();
    }

    public CarDetails findById(Long id){
        return carDetailsRepository.findAllById(id).orElseThrow();
    }

    public void delete(Long id){
        carDetailsRepository.deleteById(id);
    }
}
