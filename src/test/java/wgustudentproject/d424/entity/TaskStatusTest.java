package wgustudentproject.d424.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskStatusTest {


    @Test
    public void testEnumValues() {
        TaskStatus[] values = TaskStatus.values();

        assertEquals(4, values.length);
        assertEquals(TaskStatus.COMPLETE, values[0]);
        assertEquals(TaskStatus.IN_PROGRESS, values[1]);
        assertEquals(TaskStatus.DELAYED, values[2]);
        assertEquals(TaskStatus.HELP_REQUESTED, values[3]);
    }

    @Test
    public void testEnumToString() {
        assertEquals("COMPLETE", TaskStatus.COMPLETE.toString());
        assertEquals("IN_PROGRESS", TaskStatus.IN_PROGRESS.toString());
        assertEquals("DELAYED", TaskStatus.DELAYED.toString());
        assertEquals("HELP_REQUESTED", TaskStatus.HELP_REQUESTED.toString());
    }

    @Test
    public void testEnumStatusGetter() {
        assertEquals("Complete", TaskStatus.COMPLETE.getStatus());
        assertEquals("In Progress", TaskStatus.IN_PROGRESS.getStatus());
        assertEquals("Delayed", TaskStatus.DELAYED.getStatus());
        assertEquals("Help Requested", TaskStatus.HELP_REQUESTED.getStatus());
    }
}