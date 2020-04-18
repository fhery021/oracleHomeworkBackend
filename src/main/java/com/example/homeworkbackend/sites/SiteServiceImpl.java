package com.example.homeworkbackend.sites;

import java.util.List;
import java.util.stream.Collectors;

public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final SiteMapper siteMapper;

    public SiteServiceImpl(SiteRepository siteRepository, SiteMapper siteMapper) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
    }

    @Override
    public List<SiteDTO> getSitesByCustomerId(Long customerId) {
        // TODO replace with findByCustomerID in repository...

        List<SiteDTO> siteList = siteRepository.findAll()
                .stream()
                .filter(siteEntity -> siteEntity.getCustomer() != null && siteEntity.getCustomer().getId().equals(customerId))
                .map(siteMapper::entityToDTO)
                .collect(Collectors.toList());

        return siteList;
    }
}
