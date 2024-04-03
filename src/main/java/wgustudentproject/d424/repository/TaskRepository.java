package wgustudentproject.d424.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wgustudentproject.d424.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProject_ProjectId(int projectId);
}
