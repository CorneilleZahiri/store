package com.formationMosh.store.services;

import com.formationMosh.store.entities.Adress;
import com.formationMosh.store.entities.User;
import com.formationMosh.store.repositories.AdresseRepository;
import com.formationMosh.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final AdresseRepository adresseRepository;


    @Transactional
    public User addUser(User user) {

//        if (entityManager.contains(user)) {
//            System.out.println("Persistent");
//        } else {
//            System.out.println("Transient or detached");
//        }

//        User userResponse = userRepository.save(user);

//        if (entityManager.contains(user)) {
//            System.out.println("Persistent");
//        } else {
//            System.out.println("Transient or detached");
//        }

        return userRepository.save(user);
    }

    @Transactional
    public Adress getAdresseById(Long id) {
        return adresseRepository.findById(id).orElse(null);
    }
}
