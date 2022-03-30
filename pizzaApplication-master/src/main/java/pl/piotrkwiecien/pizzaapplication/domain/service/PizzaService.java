package pl.piotrkwiecien.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotrkwiecien.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotrkwiecien.pizzaapplication.data.entity.size.SizeEntity;
import pl.piotrkwiecien.pizzaapplication.data.repository.PizzaRepository;
import pl.piotrkwiecien.pizzaapplication.domain.mapper.PizzaMapper;
import pl.piotrkwiecien.pizzaapplication.domain.mapper.SizeMapper;
import pl.piotrkwiecien.pizzaapplication.domain.model.SizeType;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.piotrkwiecien.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, SizeRepository sizeRepository, PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token){
        checkToken(token);
        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);
        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<SizeEntity> sizeEntity = addSizeDtoList.stream().map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId())).collect(Collectors.toList());
        PizzaEntity savedSizeEntity = sizeRepository.saveAll(sizeEntity);
        List<SizeDto> sizeDtoList = sizeEntities.stream().map(sizeMapper::mapToSizeDto).collect(Collectors.toList());

    }
}
