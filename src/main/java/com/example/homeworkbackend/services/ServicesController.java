package com.example.homeworkbackend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ResponseEntity createService(
            @RequestParam Long customerId,
            @RequestBody ServicesDTO servicesDTO
    ) {
        ServicesDTO created = servicesService.createService(customerId, servicesDTO);
        if (created == null) {
            return badRequest().body("Customer with id + " + customerId + " not found");
        }
        return ResponseEntity.ok(created);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<ServicesDTO>> getServiceByCustomerId(
            @RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(servicesService.getServicesByCustomerId(customerId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServicesDTO>> getAllServices() {
        return ResponseEntity.ok(servicesService.findAll());
    }


}
