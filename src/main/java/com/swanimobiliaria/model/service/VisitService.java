package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.VisitConverter;
import com.swanimobiliaria.model.domain.Visit;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.dto.VisitDTO;
import com.swanimobiliaria.model.messaging.ReminderSender;
import com.swanimobiliaria.model.repository.VisitJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
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
                .map(VisitConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    /**
     * This service creates a new visit appointment
     */
    public VisitDTO createVisit(VisitDTO visitDTO) {
        Visit savedVisit = visitJpaRepository.save(VisitConverter.fromDTOtoDomain(visitDTO));
        return VisitConverter.fromDomainToDTO(savedVisit);
    }

    /**
     * This service returns the upcoming visits from the current date
     */
    public List<VisitDTO> getUpcomingVisits(UUID authorization) {
        userService.findByUserId(authorization);
        return visitJpaRepository.getUpcomingVisits()
                .stream()
                .map(VisitConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    /**
     * This service gets all next day visits and send the costumer a reminder
     */
    public void sendVisitReminder() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC-3"));
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, +1);
        Date tomorrow = calendar.getTime();

        List<Visit> nextDayVisits = visitJpaRepository.getNextDayVisits(tomorrow);

        if(!nextDayVisits.isEmpty()) {
            List<VisitDTO> visitDTO = nextDayVisits.stream()
                    .map(VisitConverter::fromDomainToDTO)
                    .collect(Collectors.toList());

            visitDTO.forEach(visit -> {
                PropertyDTO propertyById = propertyService.getPropertyById(visit.getPropertyId());
                reminderSender.sendEmail(visit, propertyById);
            });
        }
    }
}
