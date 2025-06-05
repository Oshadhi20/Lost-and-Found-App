package lk.ijse.cmjd108.Lost_and_Found.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lk.ijse.cmjd108.Lost_and_Found.dto.ItemDto;
import lk.ijse.cmjd108.Lost_and_Found.entity.Item;
import lk.ijse.cmjd108.Lost_and_Found.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemDto createItem(ItemDto dto) {
        Item item = new Item(null, dto.getName(), dto.getDescription(), dto.getStatus(), null);
        return toDto(itemRepository.save(item));
    }

    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ItemDto getItemById(Long id) {
        return itemRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public ItemDto updateItem(Long id, ItemDto dto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setStatus(dto.getStatus());

        return toDto(itemRepository.save(item));
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    private ItemDto toDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setStatus(item.getStatus());
        return dto;
    }
}
