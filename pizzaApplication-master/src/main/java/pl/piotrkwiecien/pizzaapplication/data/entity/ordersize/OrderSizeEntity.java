package pl.piotrkwiecien.pizzaapplication.data.entity.ordersize;

import pl.piotrkwiecien.pizzaapplication.data.entity.order.OrderEntity;
import pl.piotrkwiecien.pizzaapplication.data.entity.size.SizeEntity;

import javax.persistence.*;

@Entity
@Table(name = "orders_sizes")
public class OrderSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name = "size_id")
    private Integer sizeId;

    @Column(name = "sizeCount")
    private Integer sizeCount;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "size_id", insertable = false, updatable = false)
    private SizeEntity size;
}
