package lk.ijse.cmjd108.Lost_and_Found.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import lk.ijse.cmjd108.Lost_and_Found.entity.Item;
import lk.ijse.cmjd108.Lost_and_Found.entity.ItemStatus;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByStatus(ItemStatus status); // e.g., get all LOST items
}
