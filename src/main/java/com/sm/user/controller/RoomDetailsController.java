package com.sm.user.controller;

import com.sm.user.document.RoomLotDetails;
import com.sm.user.document.Store;
import com.sm.user.repository.RoomLotDetailsRepository;
import com.sm.user.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/lots")
public class RoomDetailsController {

    @Autowired
    private RoomLotDetailsRepository roomLotDetailsRepository;
    @Autowired
    private StoreRepository storeRepository;

    @PostMapping("/generate/{storeId}")
    public ResponseEntity<String> generateLots(@PathVariable("storeId") String storeId) {
        Store store = storeRepository.findByStoreIdOrPhone(storeId, storeId);
        List<RoomLotDetails> roomLotDetailsList = new ArrayList<>();
        // room loop
        store.getRoomDetails().stream().forEach(roomDetails -> {
//row loop
            IntStream.range(1, roomDetails.getFloorInRoom()).forEach(row -> {
//col loop
                IntStream.range(1, roomDetails.getColumnsInRoom()).forEach(col -> {
                    String lotNo = "R-" + roomDetails.getRoomNo() + "-F-" + row + "-C-" + col + "-S-" + store.getRegistrationSessionYear() + "-S-" + storeId;
                    RoomLotDetails roomLotDetails = new RoomLotDetails();
                    roomLotDetails.setFloorNo(row);
                    roomLotDetails.setGeneratedLotName(lotNo);
                    roomLotDetails.setLotCapacity(roomDetails.getPerLotCapacity());
                    roomLotDetails.setRoomId(roomDetails.getRoomId());
                    roomLotDetails.setSession(String.valueOf(LocalDate.now().getYear()));
                    roomLotDetails.setStoreId(storeId);
                    roomLotDetailsList.add(roomLotDetails);

                });
            });
        });
        roomLotDetailsRepository.saveAll(roomLotDetailsList);
        return ResponseEntity.ok("Lot generated successfully" + roomLotDetailsList.size());
    }

}