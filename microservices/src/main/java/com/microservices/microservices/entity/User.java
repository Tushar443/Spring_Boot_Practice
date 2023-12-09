package com.microservices.microservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private String email;

    private String name;

    private String password;
}
