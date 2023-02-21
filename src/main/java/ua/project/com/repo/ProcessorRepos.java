package ua.project.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.Processor;

public interface ProcessorRepos extends JpaRepository<Processor, Long> {
}
