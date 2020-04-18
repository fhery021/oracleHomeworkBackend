package com.example.homeworkbackend.services;

import com.example.homeworkbackend.common.AcknowledgeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<ServicesDTO>> getServiceByCustomerId(
            @RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(servicesService.geServicesByCustomerId(customerId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServicesDTO>> getAllServices() {
        return ResponseEntity.ok(servicesService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServicesDTO> applyCustomer(
            @RequestParam Long customerId,
            @RequestParam Long serviceId
    ) {
        ServicesDTO dto = servicesService.applyCustomer(customerId, serviceId);
        return ResponseEntity.ok(dto);
    }
}
