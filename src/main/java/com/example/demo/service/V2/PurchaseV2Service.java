package com.example.demo.service.V2;

import com.example.demo.dto.Purchase.RequestPurchaseDTO;
import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.entity.Purchase;
import com.example.demo.interfaces.services.IPurchaseService;
import com.example.demo.repository.*;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseV2Service  implements IPurchaseService {
    final IPurchaseRepository purchaseRepository;
    final ICustomerRepository customerRepository;
    final IPharmacyRepository pharmacyRepository;
    final IPharmacistRepository pharmacistRepository;
    final IRemedyRepository remedyRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponsePurchaseDTO> findAll() {
        List<Purchase> list = purchaseRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponsePurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponsePurchaseDTO findById(Long id) throws NotFoundException {
        if(!purchaseRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(purchaseRepository.findById(id).orElse(null), ResponsePurchaseDTO.class);
    }

    @Override
    public ResponsePurchaseDTO update(Long id, RequestPurchaseDTO dto) throws NotFoundException {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);

        if(!purchaseRepository.existsById(id)) throw new NotFoundException("Purchase with specified id not found");
        if(!customerRepository.existsById(dto.getCustomerId())) throw new NotFoundException("Train with specified id not found");
        if(!pharmacyRepository.existsById(dto.getPharmacyId())) throw new NotFoundException("Train with specified id not found");
        if(!pharmacistRepository.existsById(dto.getPharmacistId())) throw new NotFoundException("Train with specified id not found");
        if(!remedyRepository.existsById(dto.getRemedyId())) throw new NotFoundException("Train with specified id not found");

        Purchase entity = modelMapper.map(dto, Purchase.class);
        entity.setId(id);
        entity.setCustomer(customerRepository.getOne(dto.getCustomerId()));
        entity.setPharmacy(pharmacyRepository.getOne(dto.getPharmacyId()));
        entity.setPharmacist(pharmacistRepository.getOne(dto.getPharmacistId()));
        entity.setRemedy(remedyRepository.getOne(dto.getRemedyId()));

        return modelMapper.map(purchaseRepository.save(entity), ResponsePurchaseDTO.class);
    }

    @Override
    public ResponsePurchaseDTO create(RequestPurchaseDTO dto) throws NotFoundException {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);

        if(!customerRepository.existsById(dto.getCustomerId())) throw new NotFoundException("Train with specified id not found");
        if(!pharmacyRepository.existsById(dto.getPharmacyId())) throw new NotFoundException("Train with specified id not found");
        if(!pharmacistRepository.existsById(dto.getPharmacistId())) throw new NotFoundException("Train with specified id not found");
        if(!remedyRepository.existsById(dto.getRemedyId())) throw new NotFoundException("Train with specified id not found");

        Purchase entity = modelMapper.map(dto, Purchase.class);
        entity.setCustomer(customerRepository.getOne(dto.getCustomerId()));
        entity.setPharmacy(pharmacyRepository.getOne(dto.getPharmacyId()));
        entity.setPharmacist(pharmacistRepository.getOne(dto.getPharmacistId()));
        entity.setRemedy(remedyRepository.getOne(dto.getRemedyId()));

        return modelMapper.map(purchaseRepository.save(entity), ResponsePurchaseDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!purchaseRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        purchaseRepository.deleteById(id);
    }
}
