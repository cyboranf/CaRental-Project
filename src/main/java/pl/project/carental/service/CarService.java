package pl.project.carental.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.User;
import pl.project.carental.repository.CarRepository;

import java.util.List;

@Service
@Transactional
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car){
        carRepository.save(car);
        return car;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Long id){
        return carRepository.findAllById(id).orElseThrow();
    }

    public void delete(Long id){
        carRepository.deleteById(id);
    }
}
