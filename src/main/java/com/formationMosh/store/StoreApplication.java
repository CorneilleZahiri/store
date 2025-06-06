package com.formationMosh.store;

import com.formationMosh.store.entities.Adress;
import com.formationMosh.store.entities.User;
import com.formationMosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);

        UserService userService = applicationContext.getBean(UserService.class);
//        ProfileService profileService = applicationContext.getBean(ProfileService.class);
        //AdresseService adresseService = applicationContext.getBean(AdresseService.class);

//        Adress adress = userService.getAdresseById(1L);
//        System.out.println(adress.getCity() + "\n" + adress.getUser().getName());

        User user = new User();
        user.setName("AMEVO");
        user.setEmail("aurelleamevo@gmail.com");
        user.setPassword("mymdp");

        Adress adress = new Adress();
        adress.setCountry("Bénin");
        adress.setCity("Cotonou");
        adress.setUser(user);

        user.getAdresses().add(adress);

        User user1 = userService.addUser(user);
        System.out.println("Votre ID est : " + user1.getId());


//        Adress adress1 = adresseService.addAdresse(adress);
//        System.out.println(adress1.getId());

//        Profile profile = new Profile();
//        profile.setBio("Mon profile");
//        profile.setUser(user1);
//
//        Profile profile1 = profileService.addProfile(profile);
//
//        System.out.println(profile1.getId() + "\n" + profile1.getBio());

        /*
        Tag tag = new Tag();
        tag.setName("Tag1er");

        tag.getUsers().add(user);
        user.getTags().add(tag);

        System.out.println(user);
        System.out.println(tag);
         */
    }

}
