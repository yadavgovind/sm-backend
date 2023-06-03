package com.sm.user.controller;

import com.sm.user.document.RoomLotDetails;
import com.sm.user.document.Store;
import com.sm.user.repository.RoomLotDetailsRepository;
import com.sm.user.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/lots")

@CrossOrigin(origins = "*",exposedHeaders = "*",allowedHeaders = "*")
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


    @GetMapping("/lotDetails/{roomId}/store/{storeId}")
    public ResponseEntity<List<RoomLotDetails>>  getRoomLotDetails(@PathVariable String roomId,@PathVariable String storeId, @RequestParam(required = false) String session){

        if(StringUtils.isEmpty(session)){
            session=String.valueOf( LocalDate.now().getYear());
        }
       return ResponseEntity.ok(roomLotDetailsRepository.findAllByRoomIdAndStoreIdAndSession(roomId,storeId,session));

    }


    @GetMapping("/available/store/{storeId}")
    public ResponseEntity<Map<String, List<RoomLotDetails>>>  getAvailable(@PathVariable String storeId, @RequestParam(required = false) String session){

        if(StringUtils.isEmpty(session)){
            session=String.valueOf( LocalDate.now().getYear());
        }
        List<RoomLotDetails> roomLotDetails = roomLotDetailsRepository.findAllByStoreIdAndSession(storeId, session);

        Map<String, List<RoomLotDetails>> availableRooms = roomLotDetails.stream().filter(item -> StringUtils.isEmpty(item.getAllocatedCustomer())).collect(Collectors.groupingBy(RoomLotDetails::getRoomNo));
        return ResponseEntity.ok(availableRooms);

    }



}