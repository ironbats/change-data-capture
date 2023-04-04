package com.cdc.architecture.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stock")
@Data
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<Lojas> lojas;
    private long stockEcommerce;


}
