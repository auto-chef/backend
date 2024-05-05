package br.com.autochef.AutoChef.dto.orderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterOrderItemDTO(

        @NotBlank @Size(max=255)
        String changes,
        @NotBlank @Size(min=1,max=3)
        int amount,
        Long productId
) {
}
