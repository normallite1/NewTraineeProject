package ua.project.com.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NonNull;
import ua.project.com.model.Computer;

import java.util.List;

@Data
public class OrderDTO {

    @NonNull
    @JsonIgnore
    private Long id;

    private String name;

    private List<ComputerDTO> computerList;
}
