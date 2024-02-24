package wgustudentproject.d424.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") int taskId) {
        TaskDTO task = taskService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable("taskId") int taskId, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTaskProgress(taskId, taskDTO);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") int taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
