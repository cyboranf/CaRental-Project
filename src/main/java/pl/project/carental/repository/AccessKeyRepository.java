package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.carental.domain.AccessKey;
import pl.project.carental.domain.User;

import java.util.Optional;

@Repository
public interface AccessKeyRepository extends JpaRepository<AccessKey,Long> {

    AccessKey save(AccessKey accessKey);

    AccessKey saveAndFlush(AccessKey accessKey);

    Optional<AccessKey> findAllById(Long id);

    void deleteById(Long id);
}
