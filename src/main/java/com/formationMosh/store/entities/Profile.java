package com.formationMosh.store.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;

    @Column(name = "loyalty_points")
    private Integer loyalty_points;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    //@JoinColumn(name = "id")
    //@MapsId
    private User user;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", loyalty_points=" + loyalty_points +
                '}';
    }
}