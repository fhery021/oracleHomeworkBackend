package com.example.homeworkbackend.sites;

import com.example.homeworkbackend.services.ServicesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/site")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<SiteDTO>> getSitesByCustomerId(
            @RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(siteService.getSitesByCustomerId(customerId));
    }
}
