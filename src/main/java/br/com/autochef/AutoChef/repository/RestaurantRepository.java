package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
}
