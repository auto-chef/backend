package br.com.autochef.AutoChef.dto.orderItem;

public record RegisterOrderItemDTO(
        String changes,
        int amount,
        Long productId
) {
}
