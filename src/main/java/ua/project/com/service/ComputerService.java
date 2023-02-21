package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.GraphicsCard;
import ua.project.com.model.Processor;
import ua.project.com.repo.ComputerRepos;

@Service
public class ComputerService {

    private final ComputerRepos computerRepos;


    public ComputerService(ComputerRepos computerRepos) {
        this.computerRepos = computerRepos;
    }

    public Computer getComputerById(Long id){
       return computerRepos.findById(id).get();
    }

    public Computer createComputer(String name){
        return computerRepos.save(Computer.builder()
                .name(name)
                .build());
    }
    public void updateComputer(Long id, String name, GraphicsCard graphicsCard,
                                Processor processor){
        Computer computer = computerRepos.findById(id).get();
        if(name != null) computer.setName(name);
        if(graphicsCard != null) computer.setGraphicsCard(graphicsCard);
        if(processor != null && !computer.getProcessorList().contains(processor)){
            computer.addProcessorToComputer(processor);
        }
        computerRepos.save(computer);
    }
    public void deleteComputer(Long id){
        computerRepos.deleteById(id);
    }

}
