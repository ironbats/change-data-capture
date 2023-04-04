package com.cdc.architecture.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lojas")
@Data
public class Lojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long quantity;

}
