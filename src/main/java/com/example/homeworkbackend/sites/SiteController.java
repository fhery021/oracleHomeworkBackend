package com.example.homeworkbackend.sites;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/api/v1/site")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping
    public ResponseEntity createSite(
            @RequestParam Long customerId,
            @RequestBody SiteDTO siteDTO
    ) {
        SiteDTO created = siteService.createSite(customerId, siteDTO);
        if (created == null) {
            return badRequest().body("Customer with id + " + customerId + " not found");
        }
        return ResponseEntity.ok(created);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<SiteDTO>> getSitesByCustomerId(
            @RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(siteService.getSitesByCustomerId(customerId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SiteDTO>> getAllServices() {
        return ResponseEntity.ok(siteService.findAll());
    }

}
