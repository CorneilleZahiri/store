package com.formationMosh.store.services;

import com.formationMosh.store.entities.Profile;
import com.formationMosh.store.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Transactional
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }
}
