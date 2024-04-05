package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
