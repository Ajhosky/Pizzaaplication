package pl.dominiksobolewski.pizzaapplication.remote.rest.dto.request;

import java.util.List;

public class AddPizzaDto {
    private String name;
    private List<AddSizeDto> addSizeDtoList;

    public AddPizzaDto() {
    }

    public AddPizzaDto(String name, List<AddSizeDto> sizes) {
        this.name = name;
        addSizeDtoList = sizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddSizeDto> getSizes() {
        return addSizeDtoList;
    }

    public void setSizes(List<AddSizeDto> sizes) {
        this.addSizeDtoList = sizes;
    }
}
