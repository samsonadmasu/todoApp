package com.exam.userservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "appuser")
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fullName;
    private String userName;
    private boolean status;

    public AppUser() {
    }

    public AppUser(String fullName ,String userName, boolean status ) {
        this.fullName = fullName;
        this.userName = userName;
        this.status = status;

    }
}
