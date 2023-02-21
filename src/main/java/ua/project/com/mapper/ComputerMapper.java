package ua.project.com.mapper;

import org.mapstruct.Mapper;
import ua.project.com.model.Computer;
import ua.project.com.modelDTO.ComputerDTO;

@Mapper(componentModel = "spring")
public interface ComputerMapper {
    ComputerDTO toDTO(Computer computer);
}
