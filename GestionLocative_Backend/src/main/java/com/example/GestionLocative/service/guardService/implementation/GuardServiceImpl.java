package com.example.GestionLocative.service.guardService.implementation;

import com.example.GestionLocative.model.Client;
import com.example.GestionLocative.model.Guard;
import com.example.GestionLocative.model.Maison;
import com.example.GestionLocative.repository.GuardRepository;
import com.example.GestionLocative.repository.MaisonRepository;
import com.example.GestionLocative.response.GuardResponse;
import com.example.GestionLocative.service.guardService.IGuardService;
import com.example.GestionLocative.service.maisonService.IMaisonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class GuardServiceImpl implements IGuardService {

    @Autowired
    private GuardRepository guardRepository;

    @Autowired
    private MaisonRepository maisonRepository;

    @Override
    public GuardResponse addNewGuard(Long maisonId) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.equals(null)) return null;
        Guard guard = new Guard();
        guard.setMaison(maison.get());
        guard.setJanuary(false);
        guard.setFebruary(false);
        guard.setMarch(false);
        guard.setApril(false);
        guard.setMay(false);
        guard.setJune(false);
        guard.setJuly(false);
        guard.setAugust(false);
        guard.setSeptember(false);
        guard.setOctober(false);
        guard.setNovember(false);
        guard.setDecember(false);
        guardRepository.save(guard);
        GuardResponse guardResponse = new GuardResponse();
        BeanUtils.copyProperties(guard, guardResponse);
        guardResponse.setMaisonId(maisonId);
        return guardResponse;
    }

    @Override
    public GuardResponse getGuard(Long guardId) {
        Optional<Guard> guard = guardRepository.findById(guardId);
        if (guard.isEmpty()) return null;
        GuardResponse guardResponse = new GuardResponse();
        BeanUtils.copyProperties(guard, guardResponse);
        guardResponse.setMaisonId(guard.get().getMaison().getId());
        return guardResponse;
    }

    @Override
    public GuardResponse updateGuard(Long maisonId, Guard guard) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.equals(null)) return null;
        maison.get().setGuard(guard);
        maisonRepository.save(maison.get());
        GuardResponse guardResponse = new GuardResponse();
        BeanUtils.copyProperties(guard, guardResponse);
        guardResponse.setMaisonId(maisonId);
        return guardResponse;
    }
}
