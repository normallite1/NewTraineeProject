package ua.project.com.service;

import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.GraphicsCard;
import ua.project.com.repo.GraphicsCardRepos;

@Service
public class GraphicsCardService {

    private final GraphicsCardRepos graphicsCardRepos;

    public GraphicsCardService(GraphicsCardRepos graphicsCardRepos) {
        this.graphicsCardRepos = graphicsCardRepos;
    }

    public GraphicsCard getGraphicsCardById(Long id){
        return graphicsCardRepos.findById(id).get();
    }

    public GraphicsCard createGraphicsCard(String name, Integer price) {
       return graphicsCardRepos.save(GraphicsCard.builder()
                .name(name)
                .price(price)
                .build());
    }

    public void updateGraphicsCard(Long id, String name, Integer price, Computer computer) {
        GraphicsCard graphicsCard = graphicsCardRepos.findById(id).get();
        if(name !=null) graphicsCard.setName(name);
        if(price !=null) graphicsCard.setPrice(price);
        if(computer !=null && !graphicsCard.getComputer().equals(computer)) graphicsCard.setComputer(computer);
        graphicsCardRepos.save(graphicsCard);
    }

    public void deleteGraphicsCard(Long id) {
        graphicsCardRepos.deleteById(id);
    }
}
