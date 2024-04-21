package wgustudentproject.d424.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {

        task = new Task();
        task.setId(1L);
        task.setTaskName("Sample Task");
        task.setTaskDescription("Sample Description");
        task.setTaskStatus(TaskStatus.IN_PROGRESS);
        task.setTaskCommitDate(LocalDate.now());
        task.setProject(new Project());

    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, task.getId());
        assertEquals("Sample Task", task.getTaskName());
        assertEquals("Sample Description", task.getTaskDescription());
        assertEquals(TaskStatus.IN_PROGRESS, task.getTaskStatus());
        assertEquals(LocalDate.now(), task.getTaskCommitDate());
        assertNotNull(task.getProject());

        // You can add assertions for other fields as needed
    }

}