package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.GraphicsCard;
import ua.project.com.repository.GraphicsCardRepos;

@Service
public class GraphicsCardService {

    private final GraphicsCardRepos graphicsCardRepository;

    public GraphicsCardService(GraphicsCardRepos graphicsCardRepository) {
        this.graphicsCardRepository = graphicsCardRepository;
    }

    public GraphicsCard getGraphicsCardById(Long id){
        return graphicsCardRepository.findById(id).get();
    }

    public GraphicsCard createGraphicsCard(String name, Integer price) {
       return graphicsCardRepository.save(GraphicsCard.builder()
                .name(name)
                .price(price)
                .build());
    }

    public void updateGraphicsCard(Long id, String name, Integer price, Computer computer) {
        GraphicsCard graphicsCard = graphicsCardRepository.findById(id).get();
        if(name !=null) graphicsCard.setName(name);
        if(price !=null) graphicsCard.setPrice(price);
        if(computer !=null && !graphicsCard.getComputer().equals(computer)) graphicsCard.setComputer(computer);
        graphicsCardRepository.save(graphicsCard);
    }

    public void deleteGraphicsCard(Long id) {
        graphicsCardRepository.deleteById(id);
    }
}
