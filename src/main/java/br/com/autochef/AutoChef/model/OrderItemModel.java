package br.com.autochef.AutoChef.model;


import br.com.autochef.AutoChef.dto.orderItem.RegisterOrderItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;


@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItemModel {
    @Id
    @GeneratedValue
    @Column(name = "ID_ITEM")
    private Long id;
    
    @Column(name = "DS_ORDER_CHANGE", nullable = false, length = 255)
    private String orderChange;

    @Column(name = "DS_AMOUNT", nullable = false, precision = 3)
    private int amount;

    @ManyToOne
    private OrderModel order;

    @ManyToOne
    private ProductModel product;

    public OrderItemModel(RegisterOrderItemDTO registerOrderItemDTO, ProductModel productModel, OrderModel order) {
        this.orderChange = registerOrderItemDTO.changes();
        this.amount = registerOrderItemDTO.amount();
        this.product = productModel;
        this.order = order;

    }

}
