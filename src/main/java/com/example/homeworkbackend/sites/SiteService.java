package com.example.homeworkbackend.sites;

import java.util.List;

public interface SiteService {

    SiteDTO createSite(Long customerId, SiteDTO siteDTO);

    List<SiteDTO> getSitesByCustomerId(Long customerId);

    List<SiteDTO> findAll();
}
