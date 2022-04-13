package pl.dominiksobolewski.pizzaapplication.domain.service;

import pl.dominiksobolewski.pizzaapplication.domain.exception.ResourceNotFoundException;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.response.TokenDto;

import java.lang.module.ResolutionException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddOrderService {
    public TokenDto addOrder(AddOrderDto addOrderDto){

        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(pizzaOrderDto -> pizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        Boolean existsSizes = sizeRepository.existsAllByIdIn(sizeIds);
        if (!existsSizes) {
        throw new ResourceNotFoundException("Pizza o podanym rozmiarze nie istnieje w bazie danyck");

        }
        String token = UUID.randomUUID().toString();

    }

}
