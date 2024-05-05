package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.dto.orderItem.RegisterOrderItemDTO;
import jakarta.validation.constraints.*;

import java.util.List;

public record RegisterOrderDTO(
        @NotNull @NotEmpty
        List<RegisterOrderItemDTO> items,

        @NotNull
        Long restaurantId,

        @NotNull
        Long userId
) {
}
