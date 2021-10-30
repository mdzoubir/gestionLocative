package com.example.GestionLocative.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "admins")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends AppUser{

    @OneToMany(mappedBy = "admin", cascade = CascadeType.REMOVE)
    private Collection<Maison> maisons;

}
