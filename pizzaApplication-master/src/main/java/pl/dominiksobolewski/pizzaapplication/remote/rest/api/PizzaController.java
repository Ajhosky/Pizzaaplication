package pl.dominiksobolewski.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominiksobolewski.pizzaapplication.domain.service.PizzaService;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.AddPizzaDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class PizzaController {

    private final PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }


    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestHeader("Access-Token") String token,
                                             @RequestBody AddPizzaDto addPizzaDto) {
        PizzaDto pizzaDto = pizzaService.addPizza(addPizzaDto, token);
        return ResponseEntity.ok(pizzaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestHeader("Access-Token") String token,
                                                @PathVariable("id") Integer pizzaId,
                                                @RequestBody UpdatePizzaDto updatePizzaDto) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@RequestHeader("Access-Token") String token, @PathVariable("id") Integer pizzaId) {
        return ResponseEntity.ok().build();
    }
}