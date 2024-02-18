package wgustudentproject.d424.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    // Define the relationship with a single team member
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User teamMember;

    // Define the relationship with a single project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
