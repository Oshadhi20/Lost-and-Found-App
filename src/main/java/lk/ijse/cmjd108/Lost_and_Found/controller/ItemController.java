package lk.ijse.cmjd108.Lost_and_Found.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd108.Lost_and_Found.dto.ItemDto;
import lk.ijse.cmjd108.Lost_and_Found.service.ItemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public ItemDto updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.updateItem(id, itemDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok("Item deleted successfully");
    }
}