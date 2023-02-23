package ua.project.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.Processor;

public interface ProcessorRepos extends JpaRepository<Processor, Long> {
}
