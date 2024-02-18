package wgustudentproject.d424.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wgustudentproject.d424.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
