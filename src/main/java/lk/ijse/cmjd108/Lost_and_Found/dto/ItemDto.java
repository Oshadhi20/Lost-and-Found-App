package lk.ijse.cmjd108.Lost_and_Found.dto;

import lk.ijse.cmjd108.Lost_and_Found.entity.ItemStatus;
import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private ItemStatus status; // LOST, FOUND, CLAIMED
}