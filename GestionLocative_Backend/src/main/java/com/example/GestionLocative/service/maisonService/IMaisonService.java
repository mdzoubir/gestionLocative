package com.example.GestionLocative.service.maisonService;


import com.example.GestionLocative.model.Maison;
import com.example.GestionLocative.response.MaisonResponse;

import java.util.List;

public interface IMaisonService  {
    MaisonResponse addNewMaison(Maison maison, String clientId, String adminId);
    MaisonResponse getMaison(Long maisonId);
    List<MaisonResponse> getAllMaison();
    void deleteMaison(Long maisonId);
}
