package br.com.autochef.AutoChef.repository;

import br.com.autochef.AutoChef.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
