package com.example.homeworkbackend.generator.services;

import com.example.homeworkbackend.services.ServicesDTO;
import com.example.homeworkbackend.services.ServicesType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomServicesData {

    public ServicesDTO generateServicesData() {

        LocalDate randomStart = randomStartDate();
        LocalDate randomEnd = randomEndDate(randomStart);
        ServicesType type = randomType();

        return ServicesDTO.builder()
                .type(type)
                .startDate(randomStart)
                .endDate(randomEnd)
                .description(description(type))
                .build();
    }

    private ServicesType randomType() {
        List<ServicesType> types = Arrays.asList(ServicesType.values());
        Collections.shuffle(types);
        return types.stream().findFirst().get();
    }

    private LocalDate randomStartDate() {
        return LocalDate.now()
                .plusDays(ThreadLocalRandom.current().nextInt(0, 5));
    }

    private LocalDate randomEndDate(LocalDate randomStart) {
        return randomStart.plusDays(ThreadLocalRandom.current().nextInt(1, 5));
    }

    private String description(ServicesType type) {
        switch (type) {
            case A:
                return "\"Infrastructure as a service\" (IaaS) refers to online services that provide high-level APIs used to dereference various low-level details of underlying network infrastructure like physical computing resources, location, data partitioning, scaling, security, backup, etc. A hypervisor runs the virtual machines as guests. Pools of hypervisors within the cloud operational system can support large numbers of virtual machines and the ability to scale services up and down according to customers' varying requirements. Linux containers run in isolated partitions of a single Linux kernel running directly on the physical hardware. Linux cgroups and namespaces are the underlying Linux kernel technologies used to isolate, secure and manage the containers. Containerisation offers higher performance than virtualization because there is no hypervisor overhead. Also, container capacity auto-scales dynamically with computing load, which eliminates the problem of over-provisioning and enables usage-based billing.[69] IaaS clouds often offer additional resources such as a virtual-machine disk-image library, raw block storage, file or object storage, firewalls, load balancers, IP addresses, virtual local area networks (VLANs), and software bundles.[";
            case B:
                return "The capability provided to the consumer is to deploy onto the cloud infrastructure consumer-created or acquired applications created using programming languages, libraries, services, and tools supported by the provider. The consumer does not manage or control the underlying cloud infrastructure including network, servers, operating systems, or storage, but has control over the deployed applications and possibly configuration settings for the application-hosting environment.";
            case C:
                return "The capability provided to the consumer is to use the provider's applications running on a cloud infrastructure. The applications are accessible from various client devices through either a thin client interface, such as a web browser (e.g., web-based email), or a program interface. The consumer does not manage or control the underlying cloud infrastructure including network, servers, operating systems, storage, or even individual application capabilities, with the possible exception of limited user-specific application configuration settings.";
            default:
                return "In the mobile \"backend\" as a service (m) model, also known as backend as a service (BaaS), web app and mobile app developers are provided with a way to link their applications to cloud storage and cloud computing services with application programming interfaces (APIs) exposed to their applications and custom software development kits (SDKs).";
        }
    }
}
