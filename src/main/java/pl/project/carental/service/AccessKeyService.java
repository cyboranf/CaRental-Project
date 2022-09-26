package pl.project.carental.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.carental.domain.AccessKey;
import pl.project.carental.domain.Car;
import pl.project.carental.repository.AccessKeyRepository;

import java.util.List;

@Service
@Transactional
public class AccessKeyService {
    private final AccessKeyRepository accessKeyRepository;

    public AccessKeyService(AccessKeyRepository accessKeyRepository) {
        this.accessKeyRepository = accessKeyRepository;
    }

    public AccessKey saveAccessKey(AccessKey accessKey){
        accessKeyRepository.save(accessKey);
        return accessKey;
    }

    public List<AccessKey> findAll(){
        return accessKeyRepository.findAll();
    }

    public AccessKey findById(Long id){
        return accessKeyRepository.findAllById(id).orElseThrow();
    }

    public void delete(Long id){
        accessKeyRepository.deleteById(id);
    }
}
