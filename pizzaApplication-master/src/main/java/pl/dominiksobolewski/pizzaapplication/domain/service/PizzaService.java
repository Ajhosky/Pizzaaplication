package pl.dominiksobolewski.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.dominiksobolewski.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.dominiksobolewski.pizzaapplication.data.entity.size.SizeEntity;
import pl.dominiksobolewski.pizzaapplication.data.repository.PizzaRepository;
import pl.dominiksobolewski.pizzaapplication.domain.mapper.PizzaMapper;
import pl.dominiksobolewski.pizzaapplication.domain.mapper.SizeMapper;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.dominiksobolewski.pizzaapplication.domain.service.AuthorizationService.checkToken;

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

         List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
         List<SizeEntity> sizeEntities = addSizeDtoList
                 .stream()
                 .map(addSizeDto -> {
                     SizeEntity sizeEntity = new SizeEntity()();
                     sizeEntity.setSizeType(sizeDto.getSize().name());
                     sizeEntity.setPriceBase(sizeDto.getPrice());
                     sizeEntity.setId(sizeDto.getId());
                     sizeEntity.setPizzaId(savedPizzaEntity.getId());
                     return sizeEntity;
                 }).collect(Collectors.toList());
         PizzaEntity savedSizeEntity = sizeRepository.saveAll(sizeEntity);


    }

}
