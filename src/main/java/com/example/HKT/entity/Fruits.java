package com.example.HKT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Fruits")
public class Fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

}
