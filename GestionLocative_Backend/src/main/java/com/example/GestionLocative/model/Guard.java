package com.example.GestionLocative.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "guards")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Guard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer year = LocalDate.now().getYear();
    private boolean january;
    private boolean february;
    private boolean march;
    private boolean april;
    private boolean may;
    private boolean june;
    private boolean july;
    private boolean august;
    private boolean september;
    private boolean october;
    private boolean november;
    private boolean december;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Maison maison;

}
