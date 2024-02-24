package wgustudentproject.d424.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long projectId;
    private String projectTitle;
    private String projectDescription;
    private String projectProgress;
    private Long projectManagerId;
    private LocalDate projectCommitDate;



}
