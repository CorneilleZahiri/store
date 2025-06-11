package com.formationMosh.store.services;

import com.formationMosh.store.dtos.UserSummary;
import com.formationMosh.store.entities.Profile;
import com.formationMosh.store.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Transactional
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Transactional
    public void findSomeProfiles() {
        List<Profile> profiles = profileRepository.findSomeProfiles(4);
        profiles.forEach(System.out::println);
    }

    @Transactional
    public void findEmailUserForEachProfiles() {
        List<Profile> profiles = profileRepository.findSomeProfiles(4);
        profiles.forEach(profile -> System.out.println(profile.getBio() + "\n" + profile.getUser().getEmail()));
    }

    @Transactional
    public void findSomeUserFromProfile() {
        List<UserSummary> userSummaries = profileRepository.findSomeUserFromProfile(4);
        userSummaries.forEach(user -> {
            //System.out.println(user);
            System.out.println(user.getId() + "\n" + user.getEmail());
        });
    }
}
