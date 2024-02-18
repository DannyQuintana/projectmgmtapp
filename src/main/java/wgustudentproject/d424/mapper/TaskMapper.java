package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.TaskDTO;
import wgustudentproject.d424.entity.Task;

public class TaskMapper {

    public TaskDTO mapToTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setTaskDescription(task.getTaskDescription());

        if (task.getTeamMember() != null){
            taskDTO.setTeamMember(UserMapper.mapToUserDTO(task.getTeamMember()));
        }

        if(task.getProject() != null){
            taskDTO.setProject(ProjectMapper.mapToProjectDTO(task.getProject()));
        }

        return taskDTO;
    }

    public static Task mapToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());

        // Map team member
        if (taskDTO.getTeamMember() != null) {
            task.setTeamMember(UserMapper.mapToUser(taskDTO.getTeamMember()));
        }

        // Map project
        if (taskDTO.getProject() != null) {
            task.setProject(ProjectMapper.mapToProject(taskDTO.getProject()));
        }

        return task;
    }

}
