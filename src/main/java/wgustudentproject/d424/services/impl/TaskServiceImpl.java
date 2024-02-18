package wgustudentproject.d424.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wgustudentproject.d424.dto.TaskDTO;
import wgustudentproject.d424.repository.TaskRepository;
import wgustudentproject.d424.services.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {



        return null;
    }

    @Override
    public TaskDTO getTaskById(int taskId) {
        return null;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return null;
    }

    @Override
    public TaskDTO updateTask(int taskId, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteTask(int taskId) {

    }
}
