package pl.piotrkwiecien.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrkwiecien.pizzaapplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

}
