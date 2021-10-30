package com.example.GestionLocative.response;


import com.example.GestionLocative.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Collection<Role> roles;
}
