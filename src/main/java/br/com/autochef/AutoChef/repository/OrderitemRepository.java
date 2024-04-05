package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.OrderItemModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemRepository extends JpaRepository<OrderItemModel, Long> {
}
