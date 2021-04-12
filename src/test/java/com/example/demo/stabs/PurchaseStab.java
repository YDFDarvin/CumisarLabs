package com.example.demo.stabs;

import com.example.demo.dto.Purchase.RequestPurchaseDTO;
import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.entity.Purchase;

public class PurchaseStab {
    public static final Long ID = 1L;
    public static Purchase getPurchase() {
        return Purchase.builder()
                .id(ID)
                .customer(CustomerStab.getCustomer())
                .remedy(RemedyStab.getRemedy())
                .pharmacist(PharmacistStab.getPharmacist())
                .pharmacy(PharmacyStab.getPharmacy())
                .build();
    }

    public static RequestPurchaseDTO getRequestDto() {
        return RequestPurchaseDTO.builder()
                .customerId(1L)
                .pharmacistId(1L)
                .pharmacyId(1L)
                .remedyId(1L)
                .build();
    }

    public static ResponsePurchaseDTO getResponseDto() {
        return ResponsePurchaseDTO.builder()
                .id(ID)
                .customer(CustomerStab.getResponseDto())
                .pharmacist(PharmacistStab.getResponseDto())
                .pharmacy(PharmacyStab.getResponseDto())
                .remedy(RemedyStab.getResponseDto())
                .build();
    }
}
