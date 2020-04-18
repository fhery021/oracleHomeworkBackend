package com.example.homeworkbackend.bootstrap;

import com.example.homeworkbackend.customer.CustomerDTO;
import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerMapper;
import com.example.homeworkbackend.customer.CustomerRepository;
import com.example.homeworkbackend.random.RandomCustomerData;
import com.example.homeworkbackend.random.RandomServicesData;
import com.example.homeworkbackend.random.RandomSiteData;
import com.example.homeworkbackend.services.*;
import com.example.homeworkbackend.sites.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final RandomCustomerData randomCustomerData;
    private final CustomerMapper customerMapper;

    private final ServicesRepository servicesRepository;
    private final RandomServicesData randomServicesData;

    private final SiteRepository siteRepository;
    private final RandomSiteData randomSiteData;
    private final ServicesService servicesService;
    private final SiteService siteService;

    public Bootstrap(CustomerRepository customerRepository,
                     RandomCustomerData randomCustomerData,
                     CustomerMapper customerMapper,
                     ServicesRepository servicesRepository,
                     RandomServicesData randomServicesData,
                     SiteRepository siteRepository,
                     RandomSiteData randomSiteData,
                     ServicesService servicesService,
                     SiteService siteService) {
        this.customerRepository = customerRepository;
        this.randomCustomerData = randomCustomerData;
        this.customerMapper = customerMapper;
        this.servicesRepository = servicesRepository;
        this.randomServicesData = randomServicesData;
        this.siteRepository = siteRepository;
        this.randomSiteData = randomSiteData;
        this.servicesService = servicesService;
        this.siteService = siteService;
    }

    @Override
    public void run(String... args) throws Exception {
        buildCustomers();
        buildServices();
        buildSites();
    }

    private void buildCustomers() {
        if (customerRepository.findAll().isEmpty()) {
            for (int i = 1; i <= 50; i++) {
                CustomerDTO dto = randomCustomerData.generateCustomerData();
                CustomerEntity entity = customerMapper.dtoToEntity(dto);
                entity.setId((long) i);
                customerRepository.save(entity);
            }
        }
    }

    private void buildServices() {
        if (servicesRepository.findAll().isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                servicesService.createService((long) i, randomServicesData.generateServicesData());
            }
            servicesService.createService((long) 1, randomServicesData.generateServicesData());
        }
    }

    private void buildSites() {
        if (siteRepository.findAll().isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                siteService.createSite((long) i, randomSiteData.generateSiteData());
            }
            siteService.createSite((long) 1, randomSiteData.generateSiteData());
        }
    }
}
