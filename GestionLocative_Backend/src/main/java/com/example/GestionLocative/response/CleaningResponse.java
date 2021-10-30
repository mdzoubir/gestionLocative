package com.example.GestionLocative.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CleaningResponse {
    private Long id;
    private Integer year;
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
    private Long maisonId;
}
