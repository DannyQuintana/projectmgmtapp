package wgustudentproject.d424.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.services.ProjectService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/projects")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO createdProject = projectService.createProject(projectDTO);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    // Endpoint to get all projects
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // Endpoint to get a project by ID
    @GetMapping("{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("projectId") int projectId) {
        ProjectDTO project = projectService.getProjectById(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    // Endpoint to update a project
    @PutMapping("{projectId}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("projectId") int projectId, @RequestBody ProjectDTO projectDTO) {
        ProjectDTO updatedProject = projectService.updateProjects(projectId, projectDTO);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    // Endpoint to delete a project
    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") int projectId) {
        projectService.deleteProjects(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
