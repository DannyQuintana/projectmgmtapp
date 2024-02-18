package wgustudentproject.d424.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wgustudentproject.d424.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
