package com.microservices.microservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "todo")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String description;
    private Date date;
    private String priority;
    private String fkUser;

    @PrePersist
    private void getTimeOperation(){
        this.date=new Date();
    }
}
