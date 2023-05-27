package com.sm.user.document.extention;

import lombok.Data;

@Data
public class RoomDetails {
    private String roomId;
    private Integer floorInRoom;
    private Integer columnInRoom;
    private Integer columnsInRoom;
    private String roomCapacity;
    private String roomNo;
    private String description;
    private Integer perLotCapacity;
}
