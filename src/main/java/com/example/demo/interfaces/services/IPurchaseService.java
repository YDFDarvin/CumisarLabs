package com.example.demo.interfaces.services;

import com.example.demo.dto.Purchase.RequestPurchaseDTO;
import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.interfaces.IDtoCrudService;

public interface IPurchaseService extends IDtoCrudService<RequestPurchaseDTO, ResponsePurchaseDTO> {
}
