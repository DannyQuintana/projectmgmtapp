package wgustudentproject.d424.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable = false, name = "project_title")
    private String projectTitle;

    @Column(nullable = false, name="project_description")
    private String projectDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    private ProjectStatus projectStatus = ProjectStatus.IN_PROGRESS;

    @Column(nullable = false, name = "project_commit_date")
    private LocalDate projectCommitDate;

    @ManyToOne
    @JoinColumn (name = "project_manager_id")
    private User projectManager;


}
