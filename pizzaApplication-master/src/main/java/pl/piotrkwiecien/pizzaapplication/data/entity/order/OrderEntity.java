package pl.piotrkwiecien.pizzaapplication.data.entity.order;

import pl.piotrkwiecien.pizzaapplication.data.entity.ordersize.OrderSizeEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name="client_address")
    private String clientAddress;

    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "floor")
    private String floor;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expectedAt")
    private Date expectedAt;

    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy = "order")
    private Set<OrderSizeEntity> orderSizes;
}
