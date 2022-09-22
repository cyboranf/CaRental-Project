package pl.project.carental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carental.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
