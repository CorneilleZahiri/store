package com.formationMosh.store;

import com.formationMosh.store.entities.Tag;
import com.formationMosh.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);

        User user = new User();
        user.setName("Corneille");
        user.setEmail("cgbeaga@gmail.com");
        user.setPassword("test");

        Tag tag = new Tag();
        tag.setName("Tag1er");

        tag.getUserSet().add(user);
        user.getTagSet().add(tag);

        System.out.println(user);
        System.out.println(tag);
    }

}
