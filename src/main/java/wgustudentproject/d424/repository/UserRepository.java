package wgustudentproject.d424.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wgustudentproject.d424.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
