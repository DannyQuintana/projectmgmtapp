package wgustudentproject.d424.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    private Project project;

    @BeforeEach
    public void setUp() {
        project = new Project();
        project.setProjectId(1L);
        project.setProjectTitle("Sample Project");
        project.setProjectDescription("Sample Description");
        project.setProjectStatus(ProjectStatus.IN_PROGRESS);
        project.setProjectCommitDate(LocalDate.now());
    }


    @Test
    public void testParameterizedConstructor() {
        String title = "Sample Project";
        String description = "Sample Description";
        ProjectStatus status = ProjectStatus.COMPLETE;

        Project project = new Project(null, title, description, status, null, null);

        // Add assertions to check that fields are initialized correctly
        assertEquals(title, project.getProjectTitle());
        assertEquals(description, project.getProjectDescription());
        assertEquals(status, project.getProjectStatus());
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, project.getProjectId());
        assertEquals("Sample Project", project.getProjectTitle());
        assertEquals("Sample Description", project.getProjectDescription());
        assertEquals(ProjectStatus.IN_PROGRESS, project.getProjectStatus());
        assertEquals(LocalDate.now(), project.getProjectCommitDate());
    }

}