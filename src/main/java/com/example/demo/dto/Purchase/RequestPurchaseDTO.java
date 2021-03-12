package com.example.demo.dto.Purchase;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class RequestPurchaseDTO implements IBaseDTO {
    private Long customerId;
    private Long pharmacyId;
    private Long pharmacistId;
    private Long remedyId;
}
