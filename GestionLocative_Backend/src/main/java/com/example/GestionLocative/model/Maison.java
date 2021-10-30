package com.example.GestionLocative.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "maisons")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Maison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private Integer area;
    @Column(nullable = false)
    private Integer chamberNumber;
    @Column(nullable = false)
    private Integer toiletNumber;
    @Column(nullable = false)
    private Integer bathroomNumber;
    @Column(nullable = false)
    private Integer floorsNumber;
    @Column(nullable = false)
    private Boolean available;
    private Double rentPrice;
    @Column(nullable = false)
    private Boolean elevator;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Admin admin;

    @OneToOne(mappedBy = "maison", cascade = CascadeType.REMOVE)
    private Guard guard;

    @OneToOne(mappedBy = "maison", cascade = CascadeType.REMOVE)
    private Cleaning cleaning;

    @OneToMany(mappedBy = "maison", cascade = CascadeType.REMOVE)
    private Collection<Image> images;
}
