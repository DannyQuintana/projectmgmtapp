package wgustudentproject.d424.controller;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.exception.ResourceNotFoundExceptionCustom;
import wgustudentproject.d424.services.ProjectService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProject_ValidInput() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectTitle("Test Project");
        projectDTO.setProjectDescription("Test Description");
        projectDTO.setProjectCommitDate(LocalDate.now());

        when(projectService.createProject(any(ProjectDTO.class))).thenReturn(projectDTO);

        ResponseEntity<ProjectDTO> response = projectController.createProject(projectDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(projectDTO, response.getBody());
    }


    @Test
    public void testGetAllProjects() {
        List<ProjectDTO> mockProjects = new ArrayList<>();
        mockProjects.add(new ProjectDTO(1L, "Project 1",
                "Description 1", "IN_PROGRESS",
                null, LocalDate.now()));
        mockProjects.add(new ProjectDTO(2L, "Project 2",
                "Description 2", "COMPLETED",
                null, LocalDate.now()));

        when(projectService.getAllProjects()).thenReturn(mockProjects);

        ResponseEntity<List<ProjectDTO>> response = projectController.getAllProjects();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProjects, response.getBody());
    }

    @Test
    public void testGetProjectById_ValidId() {
        ProjectDTO mockProject = new ProjectDTO(1L, "Project 1", "Description 1", "IN_PROGRESS", null, LocalDate.now());

        when(projectService.getProjectById(1)).thenReturn(mockProject);

        ResponseEntity<ProjectDTO> response = projectController.getProjectById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProject, response.getBody());
    }

    @Test
    public void testGetProjectById_InvalidId() {
        when(projectService.getProjectById(anyInt())).thenThrow(ResourceNotFoundExceptionCustom.class);

        assertThrows(ResourceNotFoundExceptionCustom.class, () -> {
            projectController.getProjectById(999);
        });
    }

    @Test
    public void testUpdateProject_ValidInput() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(1L);
        projectDTO.setProjectTitle("Updated Project Title");

        when(projectService.updateProjects(eq(1), any(ProjectDTO.class))).thenReturn(projectDTO);

        ResponseEntity<ProjectDTO> response = projectController.updateProject(1, projectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projectDTO, response.getBody());
    }

    @Test
    public void testDeleteProject_ValidId() {
        doNothing().when(projectService).deleteProjects(1);

        ResponseEntity<Void> response = projectController.deleteProject(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


}
