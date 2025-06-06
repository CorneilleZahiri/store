package com.formationMosh.store.services;

import com.formationMosh.store.entities.Adress;
import com.formationMosh.store.repositories.AdresseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AdresseService {
    private final AdresseRepository adresseRepository;

    @Transactional
    public Adress addAdresse(Adress adress) {
        return adresseRepository.save(adress);
    }

    @Transactional
    public Adress getAdresseById(Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

}
