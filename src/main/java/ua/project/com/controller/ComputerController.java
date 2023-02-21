package ua.project.com.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.project.com.mapper.ComputerMapper;
import ua.project.com.model.Computer;
import ua.project.com.modelDTO.ComputerDTO;
import ua.project.com.service.ComputerService;
import ua.project.com.service.GraphicsCardService;
import ua.project.com.service.ProcessorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("computer")
public class ComputerController {

    private final ComputerService computerService;
    private final ComputerMapper computerMapper;
    private final ProcessorService processorService;
    private final GraphicsCardService graphicsCardService;



    @GetMapping("/{id}")
    public ComputerDTO getComputerById(@PathVariable Long id){
        return computerMapper.toDTO(computerService.getComputerById(id));
    }
    @PostMapping("/create")
    public ComputerDTO createNewComputer(@RequestBody String name){
       return computerMapper.toDTO(computerService.createComputer(name));
    }
    @PatchMapping("/update/{id}")
    public void updateComputer(@PathVariable Long id,
                               @RequestBody String name,
                               @RequestBody Long processorId,
                               @RequestBody Long graphicsCardId){
        computerService.updateComputer(id, name,
                graphicsCardService.getGraphicsCardById(graphicsCardId),
                processorService.getProcessorById(processorId));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(@PathVariable Long id){
        computerService.deleteComputer(id);
    }
}
