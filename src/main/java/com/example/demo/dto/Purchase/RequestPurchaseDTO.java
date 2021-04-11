package com.example.demo.dto.Purchase;

import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestPurchaseDTO implements IBaseDTO {
    private Long customerId;
    private Long pharmacyId;
    private Long pharmacistId;
    private Long remedyId;
}
