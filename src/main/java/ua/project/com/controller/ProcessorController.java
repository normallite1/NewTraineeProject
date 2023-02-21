package ua.project.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.project.com.mapper.ProcessorMapper;
import ua.project.com.modelDTO.GraphicsCardDTO;
import ua.project.com.modelDTO.ProcessorDTO;
import ua.project.com.service.ComputerService;
import ua.project.com.service.ProcessorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("processor")
public class ProcessorController {

    private final ProcessorService processorService;

    private final ProcessorMapper processorMapper;

    private final ComputerService computerService;

    @GetMapping("/{id}")
    public ProcessorDTO getProcessorById(@PathVariable Long id){
        return processorMapper.toDTO(processorService.getProcessorById(id));
    }
    @PostMapping("/create")
    public ProcessorDTO createNewProcessor(@RequestBody String name,
                                           @RequestBody Integer price){
        return processorMapper.toDTO(processorService.createGraphicsCard(name,price));
    }
    @PatchMapping("/update/{id}")
    public void updateProcessor(@PathVariable Long id,
                                @RequestBody String name,
                                @RequestBody Integer price,
                                @RequestBody Long computerId){
        processorService.updateProcessor(id,name,price,
                computerService.getComputerById(computerId));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProcessor(@PathVariable Long id){
        processorService.deleteProcessor(id);
    }
}
