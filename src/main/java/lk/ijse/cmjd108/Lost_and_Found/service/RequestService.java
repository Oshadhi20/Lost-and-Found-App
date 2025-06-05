package lk.ijse.cmjd108.Lost_and_Found.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lk.ijse.cmjd108.Lost_and_Found.dto.RequestDto;
import lk.ijse.cmjd108.Lost_and_Found.entity.Item;
import lk.ijse.cmjd108.Lost_and_Found.entity.User;
import lk.ijse.cmjd108.Lost_and_Found.repository.ItemRepository;
import lk.ijse.cmjd108.Lost_and_Found.repository.RequestRepository;
import lk.ijse.cmjd108.Lost_and_Found.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public RequestDto createRequest(RequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Item item = itemRepository.findById(dto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Request request = new Request(null, item, user, dto.getStatus());
        return toDto(requestRepository.save(request));
    }

    public List<RequestDto> getAllRequests() {
        return requestRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public RequestDto getRequestById(Long id) {
        return requestRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    public RequestDto updateRequest(Long id, RequestDto dto) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(dto.getStatus());
        return toDto(requestRepository.save(request));
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

    private RequestDto toDto(Request request) {
        RequestDto dto = new RequestDto();
        dto.setId(request.getId());
        dto.setItemId(request.getItem().getId());
        dto.setUserId(request.getUser().getId());
        dto.setStatus(request.getStatus());
        return dto;
    }
}
