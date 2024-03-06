package wgustudentproject.d424.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wgustudentproject.d424.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
