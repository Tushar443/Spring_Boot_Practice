package com.microservices.microservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "todo")
@Getter @Setter
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
