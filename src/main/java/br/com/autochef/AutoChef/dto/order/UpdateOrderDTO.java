package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.enums.OrderStatus;
import jakarta.validation.constraints.*;

public record UpdateOrderDTO(
        OrderStatus status,
        @NotBlank @Size(max=355)
        String feedbackDescription,
        @Min(1) @Max(5)
        Integer feedbackRate) {
}
