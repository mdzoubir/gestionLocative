package com.example.GestionLocative.service.cleaningService;

import com.example.GestionLocative.model.Cleaning;
import com.example.GestionLocative.response.CleaningResponse;

public interface ICleaningService {
    CleaningResponse addNewCleaning(Long maisonId);
    CleaningResponse getCleaning(Long cleaningId);
    CleaningResponse updateCleaning(Long maisonId, Cleaning cleaning);
}
