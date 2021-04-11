package com.example.demo.dto.Purchase;

import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePurchaseDTO implements IBaseDTO {
    private Long id;
    private ResponseCustomerDTO customer;
    private ResponsePharmacyDTO pharmacy;
    private ResponsePharmacistDTO pharmacist;
    private ResponseRemedyDTO remedy;
}
