package am.itspace.taskmaster.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne (cascade = CascadeType.MERGE)
    private Task task;
    @Column(name = "start_date_time")
    private long startDateTime;
    @Column(name = "end_date_time")
    private long endDateTime;
    @OneToOne (cascade = CascadeType.MERGE)
    private User user;



}