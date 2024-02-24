package wgustudentproject.d424.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private Long teamMemberId;
    private Long projectId;
    private LocalDate taskCommitDate;

    public TaskDTO(Long id, String taskName, String taskDescription, String taskStatus, Long teamMemberId, LocalDate taskCommitDate) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.teamMemberId = teamMemberId;
        this.taskCommitDate = taskCommitDate;
    }

}
