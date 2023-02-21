package ua.project.com.mapper;

import org.mapstruct.Mapper;
import ua.project.com.model.GraphicsCard;
import ua.project.com.modelDTO.GraphicsCardDTO;

@Mapper(componentModel = "spring")
public interface GraphicsCardMapper {
    GraphicsCardDTO toDTO(GraphicsCard graphicsCard);
}
