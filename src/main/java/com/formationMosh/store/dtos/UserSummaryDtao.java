package com.formationMosh.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSummaryDtao {
    Long id;
    String name;
    String email;
    String password;

    @Override
    public String toString() {
        return "UserSummaryDtao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
