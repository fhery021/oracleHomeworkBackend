package com.example.homeworkbackend.sites;

import java.util.List;

public interface SiteService {
    List<SiteDTO> getSitesByCustomerId(Long customerId);
}
