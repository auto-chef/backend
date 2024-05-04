package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.dto.orderItem.RegisterOrderItemDTO;

import java.util.List;

public record RegisterOrderDTO(
        List<RegisterOrderItemDTO> items,
        Long restaurantId,
        Long userId
) {
}
