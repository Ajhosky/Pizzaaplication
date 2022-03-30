package pl.dominiksobolewski.pizzaapplication.data.entity.pizza;

import pl.dominiksobolewski.pizzaapplication.data.entity.size.SizeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private Set<SizeEntity> sizes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<SizeEntity> getSizes() {
        return sizes;
    }

    public void setSizes(Set<SizeEntity> sizes) {
        this.sizes = sizes;
    }
}
