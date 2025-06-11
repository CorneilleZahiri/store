package com.formationMosh.store.services;

import com.formationMosh.store.dtos.UserSummary;
import com.formationMosh.store.entities.Adress;
import com.formationMosh.store.entities.User;
import com.formationMosh.store.repositories.AdresseRepository;
import com.formationMosh.store.repositories.ProductRepository;
import com.formationMosh.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final AdresseRepository adresseRepository;
    private final ProductRepository productRepository;


    @Transactional
    public void addUser(User user) {

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

        userRepository.save(user);
    }

    @Transactional
    public Adress getAdresseById(Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        System.out.println("Suppression effectuée avec succès");
    }

    @Transactional
    public void deleteUserFromAdresseId(Long idAdresse) {
        Adress adresse = adresseRepository.findById(idAdresse).orElse(null);
        assert adresse != null;
        this.deleteUserById(adresse.getUser().getId());
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveAllProductWithUser(Long idUser) {
        User user = this.getById(idUser);
        productRepository.findAll().forEach(product -> user.getFavoriteProducts().add(product));
        this.addUser(user);
    }

    @Transactional
    public void fetchByEmail() {
        User u = userRepository.findByEmail("cgbeaga@gmail.com").orElse(null);
        assert u != null;
        System.out.println(u.getName());
    }

    @Transactional
    public void allUser() {
        List<User> users = userRepository.findAllWithAdresses();
        users.forEach(user -> {
            System.out.println(user);
            user.getAdresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void findUserLoyalty() {
        List<UserSummary> userSummaries = userRepository.findUserLoyalty(2);
        userSummaries.forEach(userSummary -> {
            System.out.println(userSummary.getId() + " : " + userSummary.getEmail());
        });
    }
}
