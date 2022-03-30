package pl.dominiksobolewski.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request.AddPizzaDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaController {
    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto pizzaDto, @RequestHeader("Access-Token") String token){
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody UpdatePizzaDto pizzaDto, @PathVariable("id") Integer pizzaId, @RequestHeader("Access-Token") String token){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@RequestHeader("Access-Token") String token){
        return ResponseEntity.ok(null);
    }
}
