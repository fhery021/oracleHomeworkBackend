package com.example.homeworkbackend.sites;

import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerRepository;
import com.example.homeworkbackend.services.ServicesEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final SiteMapper siteMapper;
    private final CustomerRepository customerRepository;

    public SiteServiceImpl(SiteRepository siteRepository, SiteMapper siteMapper, CustomerRepository customerRepository) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public SiteDTO createSite(Long customerId, SiteDTO siteDTO) {
        if (!customerRepository.existsById(customerId)) {
            log.error("Customer with id: " + customerId + " not found.");
            return null;
        } else {
            CustomerEntity customerEntity = customerRepository.findById(customerId).get();
            SiteEntity siteEntity = siteMapper.dtoToEntity(siteDTO);
            siteEntity.setCustomer(customerEntity);
            SiteEntity saved = siteRepository.save(siteEntity);
            return siteMapper.entityToDTO(saved);
        }
    }

    @Override
    public List<SiteDTO> getSitesByCustomerId(Long customerId) {
        // TODO replace with findByCustomerID in repository...
        if (!customerRepository.existsById(customerId)) {
            log.error("Customer with id: " + customerId + " not found.");
            return null;
        } else {
            List<SiteDTO> siteList = siteRepository.findAll()
                    .stream()
                    .filter(siteEntity -> siteEntity.getCustomer() != null && siteEntity.getCustomer().getId().equals(customerId))
                    .map(siteMapper::entityToDTO)
                    .collect(Collectors.toList());

            return siteList;
        }
    }

    @Override
    public List<SiteDTO> findAll() {
        List<SiteDTO> siteDTOS = siteRepository.findAll()
                .stream()
                .map(siteMapper::entityToDTO)
                .collect(Collectors.toList());
        return siteDTOS;
    }
}
