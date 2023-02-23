package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.Processor;
import ua.project.com.repository.ProcessorRepos;

@Service
public class ProcessorService {

    private final ProcessorRepos processorRepository;

    public ProcessorService(ProcessorRepos processorRepository) {
        this.processorRepository = processorRepository;
    }

    public Processor getProcessorById(Long id){
        return processorRepository.findById(id).get();
    }

    public Processor createGraphicsCard(String name, Integer price) {
        return processorRepository.save(Processor.builder()
                .name(name)
                .price(price)
                .build());
    }
    public void updateProcessor(Long id, String name, Integer price, Computer computer) {
        Processor processor = processorRepository.findById(id).get();
        if(name !=null) processor.setName(name);
        if(price !=null) processor.setPrice(price);
        if(computer !=null && !processor.getComputer().equals(computer)) processor.setComputer(computer);
        processorRepository.save(processor);
    }
    public void deleteProcessor(Long id){
        processorRepository.deleteById(id);
    }
}
