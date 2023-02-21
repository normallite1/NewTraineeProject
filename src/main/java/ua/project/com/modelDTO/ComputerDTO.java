package ua.project.com.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import ua.project.com.model.GraphicsCard;
import ua.project.com.model.Order;
import ua.project.com.model.Processor;

import java.util.List;

@Data
public class ComputerDTO {

    @NonNull
    @JsonIgnore
    private Long id;

    private String name;

    private GraphicsCardDTO graphicsCard;

    private List<ProcessorDTO> processorList;

    private List<OrderDTO> orderList;
}
