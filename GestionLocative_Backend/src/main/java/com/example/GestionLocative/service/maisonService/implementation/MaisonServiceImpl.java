package com.example.GestionLocative.service.maisonService.implementation;

import com.example.GestionLocative.model.*;
import com.example.GestionLocative.repository.AdminRepository;
import com.example.GestionLocative.repository.ClientRepository;
import com.example.GestionLocative.repository.MaisonRepository;
import com.example.GestionLocative.response.CleaningResponse;
import com.example.GestionLocative.response.GuardResponse;
import com.example.GestionLocative.response.MaisonResponse;
import com.example.GestionLocative.service.adminService.IAdminService;
import com.example.GestionLocative.service.cleaningService.ICleaningService;
import com.example.GestionLocative.service.clientService.IClientService;
import com.example.GestionLocative.service.guardService.IGuardService;
import com.example.GestionLocative.service.maisonService.IMaisonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaisonServiceImpl implements IMaisonService {

    @Autowired
    private MaisonRepository maisonRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ICleaningService cleaningService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private IGuardService guardService;

    @Override
    public MaisonResponse addNewMaison(Maison maison, String clientId, String adminId) {
        Optional<Admin> admin = adminRepository.findByUserId(adminId);
        Optional<Client> client = clientRepository.findByUserId(clientId);
        if (admin.equals(null) || client.equals(null)){
            return null;
        }else{
            maison.setAdmin(admin.get());
            maison.setClient(client.get());
            maisonRepository.save(maison);
            GuardResponse guard = guardService.addNewGuard(maison.getId());
            CleaningResponse cleaning = cleaningService.addNewCleaning(maison.getId());
            MaisonResponse maisonResponse = new MaisonResponse();
            BeanUtils.copyProperties(maison, maisonResponse);
            maisonResponse.setAdminId(admin.get().getUserId());
            maisonResponse.setClientId(client.get().getUserId());
            maisonResponse.setCleaningId(cleaning.getId());
            maisonResponse.setGuardId(guard.getId());
            return maisonResponse;
        }
    }

    @Override
    public MaisonResponse getMaison(Long maisonId) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.isEmpty()) return null;
        MaisonResponse maisonResponse = new MaisonResponse();
        BeanUtils.copyProperties(maison, maisonResponse);
        maisonResponse.setAdminId(maison.get().getAdmin().getUserId());
        maisonResponse.setClientId(maison.get().getClient().getUserId());
        return maisonResponse;
    }

    @Override
    public List<MaisonResponse> getAllMaison() {
        List<Maison> maisons = maisonRepository.findAll();
        List<MaisonResponse> maisonResponses = new ArrayList<>();
        for (Maison maison : maisons){
            MaisonResponse maisonResponse = new MaisonResponse();
            BeanUtils.copyProperties(maison, maisonResponse);
            maisonResponse.setCleaningId(maison.getCleaning().getId());
            maisonResponse.setAdminId(maison.getAdmin().getUserId());
            maisonResponse.setClientId(maison.getClient().getUserId());
            maisonResponse.setGuardId(maison.getGuard().getId());
            maisonResponses.add(maisonResponse);
        }
        return maisonResponses;
    }

    @Override
    public void deleteMaison(Long maisonId) {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        maisonRepository.delete(maison.get());
    }
}
