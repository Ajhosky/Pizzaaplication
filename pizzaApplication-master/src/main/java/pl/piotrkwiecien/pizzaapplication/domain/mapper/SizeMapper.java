package pl.piotrkwiecien.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.piotrkwiecien.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotrkwiecien.pizzaapplication.data.entity.size.SizeEntity;
import pl.piotrkwiecien.pizzaapplication.domain.model.SizeType;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SizeMapper {
    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId){
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType(addSizeDto.getSize().name());
        sizeEntity.setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }

    public mapToSizeDto(SizeEntity sizeEntity){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setSize(SizeType.valueOf(sizeEntity().getSizeType()));

    });
    }
}
