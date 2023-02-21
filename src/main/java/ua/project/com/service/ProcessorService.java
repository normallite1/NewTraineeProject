package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.GraphicsCard;
import ua.project.com.model.Processor;
import ua.project.com.repo.ProcessorRepos;

@Service
public class ProcessorService {

    private final ProcessorRepos processorRepos;

    public ProcessorService(ProcessorRepos processorRepos) {
        this.processorRepos = processorRepos;
    }

    public Processor getProcessorById(Long id){
        return processorRepos.findById(id).get();
    }

    public Processor createGraphicsCard(String name, Integer price) {
        return processorRepos.save(Processor.builder()
                .name(name)
                .price(price)
                .build());
    }
    public void updateProcessor(Long id, String name, Integer price, Computer computer) {
        Processor processor = processorRepos.findById(id).get();
        if(name !=null) processor.setName(name);
        if(price !=null) processor.setPrice(price);
        if(computer !=null && !processor.getComputer().equals(computer)) processor.setComputer(computer);
        processorRepos.save(processor);
    }
    public void deleteProcessor(Long id){
        processorRepos.deleteById(id);
    }
}
