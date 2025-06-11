package com.formationMosh.store.repositories;

import com.formationMosh.store.dtos.UserSummary;
import com.formationMosh.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(attributePaths = {"tags", "adresses"})
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "adresses")
    @Query("SELECT u FROM User u")
    List<User> findAllWithAdresses();

    
    @Query("SELECT u.id as id, u.email as email FROM User u WHERE u.profile.loyalty_points > :paramPoint ORDER BY u.email")
    List<UserSummary> findUserLoyalty(@Param("paramPoint") int loyalty_point);
}
