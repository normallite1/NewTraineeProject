package ua.project.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.project.com.model.Order;

public interface OrderRepos extends JpaRepository<Order, Long> {
}
