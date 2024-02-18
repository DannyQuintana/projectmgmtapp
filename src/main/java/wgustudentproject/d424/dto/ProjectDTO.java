package wgustudentproject.d424.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private int projectId;
    private String projectTitle;
    private String projectDescription;
    private UserDTO projectManger;
    private List<UserDTO> teamMembers;
}
