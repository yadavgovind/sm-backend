package com.sm.user.controller;

import com.sm.user.document.ProductIn;
import com.sm.user.repository.ProductInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "*",exposedHeaders = "*",allowedHeaders = "*")
public class ProductInController {
    @Autowired
    private ProductInRepository productInRepository;

    @PostMapping("/productin")
    public ResponseEntity<ProductIn> create(@RequestBody ProductIn productIn){

        return ResponseEntity.ok(productInRepository.save(productIn));
    }

    @GetMapping("/productIn/lookup")
    public  ResponseEntity<List<ProductIn>> getProductDetailsByLotNo(@RequestParam(required = false) String lotId
    ,@RequestParam(required = false) String storeId,  @RequestParam(required = false) String roomId){
    List<ProductIn> productIns= new ArrayList<>();
    if(!StringUtils.isEmpty(lotId)){
        productIns=productInRepository.findAllByLotNo(lotId);;
    }else if(!StringUtils.isEmpty(roomId)){
        productIns= productInRepository.findAllByRoomNo(roomId);
    }else if(!StringUtils.isEmpty(storeId)){
        productIns= productInRepository.findAllByStoreId(storeId);
    }

    return ResponseEntity.ok(productIns);
    }

}
