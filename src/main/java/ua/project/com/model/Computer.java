package ua.project.com.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "graphicsCard_id")
    private GraphicsCard graphicsCard;

    @OneToMany (mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Processor> processorList;

    @ManyToMany(mappedBy = "computerList")
    private List<Order> orderList;

    public void addProcessorToComputer(Processor processor) {
        processorList.add(processor);
    }
}

