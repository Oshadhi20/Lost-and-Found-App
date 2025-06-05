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

import lk.ijse.cmjd108.Lost_and_Found.dto.RequestDto;
import lk.ijse.cmjd108.Lost_and_Found.service.RequestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'STAFF')")
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public RequestDto createRequest(@RequestBody RequestDto requestDto) {
        return requestService.createRequest(requestDto);
    }

    @GetMapping
    public List<RequestDto> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public RequestDto getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/{id}")
    public RequestDto updateRequest(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        return requestService.updateRequest(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }
}