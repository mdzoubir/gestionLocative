package com.example.GestionLocative.service.guardService;


import com.example.GestionLocative.model.Guard;
import com.example.GestionLocative.response.GuardResponse;

public interface IGuardService {
    GuardResponse addNewGuard(Long maisonId);
    GuardResponse getGuard(Long guardId);
    GuardResponse updateGuard(Long maisonId, Guard guard);
}
