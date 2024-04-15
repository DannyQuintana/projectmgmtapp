package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.TaskDTO;
import wgustudentproject.d424.entity.Project;
import wgustudentproject.d424.entity.Task;
import wgustudentproject.d424.entity.TaskStatus;
import wgustudentproject.d424.entity.User;

public class TaskMapper {

    public static TaskDTO mapToTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setTaskDescription(task.getTaskDescription());
        taskDTO.setTaskCommitDate(task.getTaskCommitDate());

        taskDTO.setTaskStatus(task.getTaskStatus().toString());

        if (task.getTeamMember() != null){
            taskDTO.setTeamMemberId(UserMapper.mapToUserDTO(task.getTeamMember()).getId());
        }

        if(task.getProject() != null){
            taskDTO.setProjectId(ProjectMapper.mapToProjectDTO(task.getProject()).getProjectId());
        }

        return taskDTO;
    }

    public static Task mapToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setTaskCommitDate(taskDTO.getTaskCommitDate());

        if(taskDTO.getTaskStatus() != null){
            TaskStatus taskStatus = TaskStatus.valueOf(taskDTO.getTaskStatus());
            task.setTaskStatus(taskStatus);
        }


        // Map team member
        if (taskDTO.getTeamMemberId() != null) {
            User teamMember = new User();
            teamMember.setId(taskDTO.getTeamMemberId());
            task.setTeamMember(teamMember);
        }

        // Map project
        if (taskDTO.getProjectId() != null) {
            Project project = new Project();
            project.setProjectId(taskDTO.getProjectId());
            task.setProject(project);
        }

        return task;
    }

}
