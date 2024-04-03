package wgustudentproject.d424.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wgustudentproject.d424.dto.TaskDTO;
import wgustudentproject.d424.services.TaskService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

 //   @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("project/{projectId}")
    public ResponseEntity<List<TaskDTO>> getTaskByProjectId(@PathVariable("projectId") int projectId){
        List<TaskDTO> tasks = taskService.getAllTaskByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") int taskId) {
        TaskDTO task = taskService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable("taskId") int taskId, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTaskProgress(taskId, taskDTO);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") int taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
