package ua.project.com.mapper;

import org.mapstruct.Mapper;
import ua.project.com.model.Processor;
import ua.project.com.modelDTO.ProcessorDTO;

@Mapper(componentModel = "spring")
public interface ProcessorMapper {
    ProcessorDTO toDTO(Processor processor);
}
