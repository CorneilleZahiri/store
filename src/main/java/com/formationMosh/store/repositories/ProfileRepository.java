package com.formationMosh.store.repositories;

import com.formationMosh.store.dtos.UserSummary;
import com.formationMosh.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths = "user")
    @Query("SELECT p FROM Profile p WHERE p.loyalty_points > :paramPoint ORDER BY p.user.email")
    List<Profile> findSomeProfiles(@Param("paramPoint") int loyalty_point);

    @EntityGraph(attributePaths = "user")
    @Query("SELECT p.id as id, p.user.email as email FROM Profile p WHERE p.loyalty_points > :paramPoint ORDER BY p.user.email")
    List<UserSummary> findSomeUserFromProfile(@Param("paramPoint") int loyalty_point);
}
