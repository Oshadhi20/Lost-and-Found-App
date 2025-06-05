package lk.ijse.cmjd108.Lost_and_Found.dto;

import lk.ijse.cmjd108.Lost_and_Found.entity.RequestStatus;
import lombok.Data;

@Data
public class RequestDto {
    private Long id;
    private Long itemId;
    private Long userId;
    private RequestStatus status; // PENDING, APPROVED, REJECTED
}
