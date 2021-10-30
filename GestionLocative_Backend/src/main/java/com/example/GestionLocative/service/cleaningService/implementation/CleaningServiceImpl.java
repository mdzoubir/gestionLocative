package com.example.GestionLocative.service.cleaningService.implementation;


import com.example.GestionLocative.model.Cleaning;
import com.example.GestionLocative.model.Guard;
import com.example.GestionLocative.model.Maison;
import com.example.GestionLocative.repository.CleaningRepository;
import com.example.GestionLocative.repository.MaisonRepository;
import com.example.GestionLocative.response.CleaningResponse;
import com.example.GestionLocative.service.cleaningService.ICleaningService;
import com.example.GestionLocative.service.maisonService.IMaisonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CleaningServiceImpl implements ICleaningService {

    @Autowired
    private CleaningRepository cleaningRepository;

    @Autowired
    private MaisonRepository maisonRepository;

    @Override
    public CleaningResponse addNewCleaning(Long maisonId) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.equals(null)) return null;
        Cleaning cleaning = new Cleaning();
        cleaning.setMaison(maison.get());
        cleaning.setJanuary(false);
        cleaning.setFebruary(false);
        cleaning.setMarch(false);
        cleaning.setApril(false);
        cleaning.setMay(false);
        cleaning.setJune(false);
        cleaning.setJuly(false);
        cleaning.setAugust(false);
        cleaning.setSeptember(false);
        cleaning.setOctober(false);
        cleaning.setNovember(false);
        cleaning.setDecember(false);
        CleaningResponse cleaningResponse =new CleaningResponse();
        BeanUtils.copyProperties(cleaning, cleaningResponse);
        cleaningResponse.setMaisonId(maisonId);
        cleaningRepository.save(cleaning);
        return cleaningResponse;
    }

    @Override
    public CleaningResponse getCleaning(Long cleaningId) {
        Optional<Cleaning> cleaning = cleaningRepository.findById(cleaningId);
        if (cleaning.isEmpty()) return null;
        CleaningResponse cleaningResponse = new CleaningResponse();
        BeanUtils.copyProperties(cleaning, cleaningResponse);
        cleaningResponse.setMaisonId(cleaning.get().getMaison().getId());
        return cleaningResponse;
    }

    @Override
    public CleaningResponse updateCleaning(Long maisonId, Cleaning cleaning) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.equals(null)) return null;
        maison.get().setCleaning(cleaning);
        maisonRepository.save(maison.get());
        CleaningResponse cleaningResponse =new CleaningResponse();
        BeanUtils.copyProperties(cleaning, cleaningResponse);
        cleaningResponse.setMaisonId(cleaning.getMaison().getId());
        return cleaningResponse;
    }
}
