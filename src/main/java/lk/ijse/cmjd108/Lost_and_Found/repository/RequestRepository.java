package lk.ijse.cmjd108.Lost_and_Found.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lk.ijse.cmjd108.Lost_and_Found.entity.RequestStatus;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByUserId(Long userId);

    List<Request> findByItemId(Long itemId);

    List<Request> findByStatus(RequestStatus status);
}