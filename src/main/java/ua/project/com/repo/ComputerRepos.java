package ua.project.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.Computer;

public interface ComputerRepos extends JpaRepository<Computer, Long> {

}
