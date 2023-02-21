package ua.project.com.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;
import ua.project.com.model.Computer;

@Data
public class ProcessorDTO {

    @NonNull
    @JsonIgnore
    private Long id;

    private String name;

    private Integer price;

    private ComputerDTO client;
}
