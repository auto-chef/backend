package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRestaurant extends JpaRepository<Restaurant, Long> {
}
