package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.order.UpdateOrderDTO;
import br.com.autochef.AutoChef.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_ORDER")
public class OrderModel {
    @Id
    @GeneratedValue
    @Column(name="id_order")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="st_order", nullable = false, length = 20)
    private OrderStatus status = OrderStatus.PENDING;
    @Column(name="ds_feedback")
    private String feedbackDescription;
    @Column(name="nr_rate")
    private Integer feedbackRate;

    public void updateData(UpdateOrderDTO updateOrderDTO) {
        if(updateOrderDTO.status() != null) this.status = updateOrderDTO.status();
        if(updateOrderDTO.feedbackDescription() != null) this.feedbackDescription = updateOrderDTO.feedbackDescription();
        if(updateOrderDTO.feedbackRate() != null) this.feedbackRate = updateOrderDTO.feedbackRate();
    }
}
