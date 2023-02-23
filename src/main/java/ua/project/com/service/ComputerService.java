package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.GraphicsCard;
import ua.project.com.model.Processor;
import ua.project.com.repository.ComputerRepos;

@Service
public class ComputerService {

    private final ComputerRepos computerRepository;


    public ComputerService(ComputerRepos computerRepository) {
        this.computerRepository = computerRepository;
    }

    public Computer getComputerById(Long id){
       return computerRepository.findById(id).get();
    }

    public Computer createComputer(String name){
        return computerRepository.save(Computer.builder()
                .name(name)
                .build());
    }
    public void updateComputer(Long id, String name, GraphicsCard graphicsCard,
                                Processor processor){
        Computer computer = computerRepository.findById(id).get();
        if(name != null) computer.setName(name);
        if(graphicsCard != null) computer.setGraphicsCard(graphicsCard);
        if(processor != null && !computer.getProcessorList().contains(processor)){
            computer.addProcessorToComputer(processor);
        }
        computerRepository.save(computer);
    }
    public void deleteComputer(Long id){
        computerRepository.deleteById(id);
    }

}
