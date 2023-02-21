package ua.project.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="ordered_computers",
            joinColumns = @JoinColumn (name = "order_id"),
            inverseJoinColumns = @JoinColumn (name = "computer_id"))
    private List<Computer> computerList;

    public void addComputerInOrder(Computer computer) {
        computerList.add(computer);
    }
}
