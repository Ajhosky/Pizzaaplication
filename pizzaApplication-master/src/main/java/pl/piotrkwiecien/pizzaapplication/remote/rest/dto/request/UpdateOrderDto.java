package pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.piotrkwiecien.pizzaapplication.domain.model.OrderStatusType;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.response.OrderDto;

import java.util.List;

public class UpdateOrderDto {
    private OrderStatusType status;
    private List<OrderDto> pizzas;
    @JsonProperty("person")
    private PersonOrderDto person;

    public UpdateOrderDto() {
    }

    public UpdateOrderDto(OrderStatusType status, List<OrderDto> pizzas, PersonOrderDto person) {
        this.status = status;
        this.pizzas = pizzas;
        this.person = person;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public List<OrderDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<OrderDto> pizzas) {
        this.pizzas = pizzas;
    }

    public PersonOrderDto getPerson() {
        return person;
    }

    public void setPerson(PersonOrderDto person) {
        this.person = person;
    }
}
