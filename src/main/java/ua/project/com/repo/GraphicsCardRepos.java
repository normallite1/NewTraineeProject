package ua.project.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.GraphicsCard;

public interface GraphicsCardRepos extends JpaRepository<GraphicsCard, Long> {
}
