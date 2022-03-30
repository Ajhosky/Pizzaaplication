package pl.piotrkwiecien.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.piotrkwiecien.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request.AddPizzaDto;

@Component
public class PizzaMapper {
    private final SizeMapper sizeMapper;

    public PizzaMapper(SizeMapper sizeMapper) {
        this.sizeMapper = sizeMapper;
    }

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto){
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }
}
