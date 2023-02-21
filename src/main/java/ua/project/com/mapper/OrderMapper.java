package ua.project.com.mapper;

import org.mapstruct.Mapper;
import ua.project.com.model.Order;
import ua.project.com.modelDTO.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO(Order order);
}
