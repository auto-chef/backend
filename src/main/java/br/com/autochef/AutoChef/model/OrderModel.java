package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.order.RegisterOrderDTO;
import br.com.autochef.AutoChef.dto.order.UpdateOrderDTO;
import br.com.autochef.AutoChef.enums.OrderStatus;
import br.com.autochef.AutoChef.repository.OrderRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_ORDER")
public class OrderModel {
    @Id
    @GeneratedValue
    @Column(name="ID_ORDER")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="ST_ORDER", nullable = false, length = 20)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name="DS_FEEDBACK", length = 355)
    private String feedbackDescription;

    @Column(name="NR_RATE")
    private Integer feedbackRate;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private RestaurantModel restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemModel> orderItems = new ArrayList<>();

    public OrderModel(UserModel user, RestaurantModel restaurant) {
        this.user = user;
        this.restaurant = restaurant;
    }

    public void updateData(UpdateOrderDTO updateOrderDTO) {
        if(updateOrderDTO.status() != null) this.status = updateOrderDTO.status();
        if(updateOrderDTO.feedbackDescription() != null) this.feedbackDescription = updateOrderDTO.feedbackDescription();
        if(updateOrderDTO.feedbackRate() != null) this.feedbackRate = updateOrderDTO.feedbackRate();
    }
}
