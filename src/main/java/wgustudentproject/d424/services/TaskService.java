package wgustudentproject.d424.services;

import wgustudentproject.d424.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO getTaskById(int taskId);

    List<TaskDTO> getAllTasks();

    List<TaskDTO> getAllTaskByProjectId(int projectId);

    TaskDTO updateTaskProgress(int taskId, TaskDTO taskDTO);

    void deleteTask(int taskId);
}
