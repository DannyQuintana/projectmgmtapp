package wgustudentproject.d424.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wgustudentproject.d424.dto.TaskDTO;
import wgustudentproject.d424.entity.Task;
import wgustudentproject.d424.entity.TaskStatus;
import wgustudentproject.d424.exception.ResourceNotFoundExceptionCustom;
import wgustudentproject.d424.mapper.TaskMapper;
import wgustudentproject.d424.repository.ProjectRepository;
import wgustudentproject.d424.repository.TaskRepository;
import wgustudentproject.d424.services.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.mapToTask(taskDTO);
        Task createdTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDTO(createdTask);
    }

    @Override
    public TaskDTO getTaskById(int taskId) {
        Task taskById = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Task not found.")
        );

        return TaskMapper.mapToTaskDTO(taskById);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> allTask = taskRepository.findAll();

        return allTask.stream()
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getAllTaskByProjectId(int projectId) {
        List<Task> allTaskByProjectId = taskRepository.findAllByProject_ProjectId(projectId);

        return allTaskByProjectId.stream()
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO updateTaskProgress(int taskId, TaskDTO taskDTO) {
        Task taskById = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Task not found.")
        );

        taskById.setTaskName(taskDTO.getTaskName());
        taskById.setTaskDescription(taskDTO.getTaskDescription());


        if(taskDTO.getTaskStatus() != null){
            try{
                TaskStatus status = TaskStatus.valueOf(taskDTO.getTaskStatus());
                taskById.setTaskStatus(status);
            } catch(IllegalArgumentException e){
                throw new IllegalArgumentException(("Invalid project status"));
            }
        }

        Task updatedTaskProgress = taskRepository.save(taskById);

        return TaskMapper.mapToTaskDTO(updatedTaskProgress);
    }

    @Override
    public void deleteTask(int taskId) {
        Task taskById = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Task not found.")
        );

        taskRepository.delete(taskById);

    }
}
