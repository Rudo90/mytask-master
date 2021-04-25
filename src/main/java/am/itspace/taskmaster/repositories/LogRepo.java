package am.itspace.taskmaster.repositories;

import am.itspace.taskmaster.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log, Integer> {
}
