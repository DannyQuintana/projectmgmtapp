package wgustudentproject.d424.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private int id;
    private String taskName;
    private String taskDescription;
    private UserDTO teamMember;
    private ProjectDTO project;
}
