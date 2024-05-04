package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.OrderModel;
import br.com.autochef.AutoChef.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
