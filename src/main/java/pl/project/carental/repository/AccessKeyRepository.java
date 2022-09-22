package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carental.domain.AccessKey;

public interface AccessKeyRepository extends JpaRepository<AccessKey,Long> {
}
