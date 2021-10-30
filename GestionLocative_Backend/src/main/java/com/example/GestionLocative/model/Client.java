package com.example.GestionLocative.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "clients")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AppUser implements Serializable {

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private Collection<Maison> maisons;

}
