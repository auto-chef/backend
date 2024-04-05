package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
