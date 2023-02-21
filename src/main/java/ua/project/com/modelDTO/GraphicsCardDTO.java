package ua.project.com.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NonNull;
import ua.project.com.model.Computer;

@Data
public class GraphicsCardDTO {

    @NonNull
    @JsonIgnore
    private Long id;

    private String name;

    private Integer price;

    private ComputerDTO computer;
}
