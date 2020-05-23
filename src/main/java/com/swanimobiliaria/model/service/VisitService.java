package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.VisitConverter;
import com.swanimobiliaria.model.domain.Visit;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.dto.VisitDTO;
import com.swanimobiliaria.model.messaging.ReminderSender;
import com.swanimobiliaria.model.repository.VisitJpaRepository;
import com.swanimobiliaria.model.type.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VisitService {

    private final VisitJpaRepository visitJpaRepository;
    private final ReminderSender reminderSender;
    private final PropertyService propertyService;
    private final UserService userService;

    @Autowired
    public VisitService(VisitJpaRepository visitJpaRepository, ReminderSender reminderSender, PropertyService propertyService, UserService userService) {
        this.visitJpaRepository = visitJpaRepository;
        this.reminderSender = reminderSender;
        this.propertyService = propertyService;
        this.userService = userService;
    }

    /**
     * This service returns all the visit history - this includes the past ones
     **/
    public List<VisitDTO> getAllVisits() {
        return visitJpaRepository.findAll()
                .stream()
                .map(VisitConverter::buildDTO)
                .collect(Collectors.toList());
    }

    /**
     * This service creates a new visit appointment
     */
    public VisitDTO createVisit(VisitDTO visitDTO) {
        Visit savedVisit = visitJpaRepository.save(VisitConverter.buildDomain(visitDTO));
        return VisitConverter.buildDTO(savedVisit);
    }

    /**
     * This service returns the upcoming visits from the current date
     */
    public List<VisitDTO> getUpcomingVisits(UUID authorization) {
        userService.findByUserId(authorization);
        return visitJpaRepository.getUpcomingVisits()
                .stream()
                .map(VisitConverter::buildDTO)
                .collect(Collectors.toList());
    }

    /**
     * This service cancel an upcoming visit
     */
    public void cancelVisit(UUID authorization, UUID visitId) {
        userService.findByUserId(authorization);
        visitJpaRepository.findById(visitId).ifPresent(visit -> {
            visitJpaRepository.deleteById(visit.getId());
            PropertyDTO propertyById = propertyService.getPropertyById(visit.getImovel());
            reminderSender.sendEmail(VisitConverter.buildDTO(visit), propertyById, ProcessType.CANCEL);
        });

    }

    /**
     * This service gets all next day visits and send the costumer a reminder
     */
    public void sendVisitReminder() {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);

        List<Visit> nextDayVisits = visitJpaRepository.getNextDayVisits(tomorrow);

        if(!nextDayVisits.isEmpty()) {
            List<VisitDTO> visitDTO = nextDayVisits.stream()
                    .map(VisitConverter::buildDTO)
                    .collect(Collectors.toList());

            visitDTO.forEach(visit -> {
                PropertyDTO propertyById = propertyService.getPropertyById(visit.getPropertyId());
                reminderSender.sendEmail(visit, propertyById, ProcessType.REMINDER);
            });
        }
    }
}
