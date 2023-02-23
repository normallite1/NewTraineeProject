package ua.project.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.Computer;

public interface ComputerRepos extends JpaRepository<Computer, Long> {

}
