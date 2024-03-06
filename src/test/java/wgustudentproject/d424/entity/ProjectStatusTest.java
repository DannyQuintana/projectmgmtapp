package wgustudentproject.d424.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStatusTest {
    @Test
    public void testEnumValues() {
        ProjectStatus[] values = ProjectStatus.values();

        // Add assertions to check the expected values
        assertEquals(4, values.length);
        assertEquals(ProjectStatus.COMPLETE, values[0]);
        assertEquals(ProjectStatus.IN_PROGRESS, values[1]);
        assertEquals(ProjectStatus.DELAYED, values[2]);
        assertEquals(ProjectStatus.HELP_REQUESTED, values[3]);
    }

    @Test
    public void testEnumToString() {
        // Add assertions to check that toString() returns the expected values
        assertEquals("COMPLETE", ProjectStatus.COMPLETE.toString());
        assertEquals("IN_PROGRESS", ProjectStatus.IN_PROGRESS.toString());
        assertEquals("DELAYED", ProjectStatus.DELAYED.toString());
        assertEquals("HELP_REQUESTED", ProjectStatus.HELP_REQUESTED.toString());
    }

    @Test
    public void testEnumStatusGetter() {
        // Add assertions to check the getStatus() method
        assertEquals("Complete", ProjectStatus.COMPLETE.getStatus());
        assertEquals("In Progress", ProjectStatus.IN_PROGRESS.getStatus());
        assertEquals("Delayed", ProjectStatus.DELAYED.getStatus());
        assertEquals("Help Requested", ProjectStatus.HELP_REQUESTED.getStatus());
    }
}