package ua.project.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.project.com.mapper.GraphicsCardMapper;
import ua.project.com.modelDTO.GraphicsCardDTO;
import ua.project.com.service.ComputerService;
import ua.project.com.service.GraphicsCardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("card")
public class GraphicsCardController {

    private final GraphicsCardService graphicsCardService;

    private final GraphicsCardMapper graphicsCardMapper;
    private final ComputerService computerService;

    @GetMapping("/{id}")
    public GraphicsCardDTO getGraphicCardById(@PathVariable Long id){
        return graphicsCardMapper.toDTO(graphicsCardService.getGraphicsCardById(id));
    }
    @PostMapping("/create")
    public GraphicsCardDTO createNewGraphicCard(@RequestBody String name,
                                                @RequestBody Integer price){
        return graphicsCardMapper.toDTO(graphicsCardService.createGraphicsCard(name,price));
    }
    @PatchMapping("/update/{id}")
    public void updateGraphicCard(@PathVariable Long id,
                                  @RequestBody String name,
                                  @RequestBody Integer price,
                                  @RequestBody Long computerId){
        graphicsCardService.updateGraphicsCard(id,name,price,
                computerService.getComputerById(computerId));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteGraphicCard(@PathVariable Long id){
        graphicsCardService.deleteGraphicsCard(id);
    }
}
