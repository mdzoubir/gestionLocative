package com.example.GestionLocative.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MaisonResponse {
    private String location;
    private String city;
    private String zipCode;
    private Integer area;
    private Integer chamberNumber;
    private Integer toiletNumber;
    private Integer bathroomNumber;
    private Integer floorsNumber;
    private Boolean available;
    private Double rentPrice;
    private Boolean elevator;
    private String clientId;
    private String adminId;
    private Long guardId;
    private Long cleaningId;
}
