package ua.project.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="graphicsCards")
public class GraphicsCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    @OneToOne(mappedBy = "graphicsCard")
    private Computer computer;
}
