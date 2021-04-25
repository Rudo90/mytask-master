package am.itspace.taskmaster.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "task_title")
    private String title;
    @Column(name = "start_date")
    private Date date;
    @Column(name = "task_deadline")
    private Date deadline;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "tasks_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;
    @OneToOne(cascade = CascadeType.MERGE)
    private Project project;
    @Column(name = "log_time")
    private Double logTime;
    @Column(name = "task_status")
    @Enumerated(value = EnumType.STRING)
    private Status status;



}
