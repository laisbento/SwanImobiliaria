package com.swanimobiliaria.model.messaging;

import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.dto.VisitDTO;
import com.swanimobiliaria.model.type.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ReminderSender {

    private JavaMailSender javaMailSender;

    @Autowired
    private ReminderSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private ReminderSender() {
    }

    public void sendEmail(VisitDTO visitDTO, PropertyDTO propertyDTO, ProcessType processType) {
        SimpleMailMessage msg = new SimpleMailMessage();
        if(processType.equals(ProcessType.REMINDER)) {
            msg = buildEmailReminder(visitDTO, propertyDTO);
        } else if (processType.equals(ProcessType.CANCEL)) {
            msg = buildEmailCancelVisit(visitDTO, propertyDTO);
        }

        javaMailSender.send(msg);
    }

    private SimpleMailMessage buildEmailReminder(VisitDTO visitDTO, PropertyDTO propertyDTO) {
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = visitDTO.getVisitDate().format(simpleDateFormat);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(visitDTO.getEmail());
        msg.setSubject("Lembrete do Cisne! Você tem uma visita agendada para amanhã: " + format);
        msg.setText("Olá " + visitDTO.getName() + "!" +
                "\nEsse é um lembrete para lembrá-lo de sua visita agendada para amanhã, " + format + ", ao imóvel localizado em "
                + propertyDTO.getRua() + ", " + propertyDTO.getNumero() + ", " + propertyDTO.getCidade() + ", " + propertyDTO.getEstado() + "." +
                "\nCaso não tenha mais interesse, entre em contato pelo telefone 0800-707070." +
                "\n\nSwan Imobiliária");

        return msg;
    }

    private SimpleMailMessage buildEmailCancelVisit(VisitDTO visitDTO, PropertyDTO propertyDTO) {
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = visitDTO.getVisitDate().format(simpleDateFormat);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(visitDTO.getEmail());
        msg.setSubject("Visita de " + format + " cancelada - Swan Imobiliária");
        msg.setText("Olá " + visitDTO.getName() + "." +
                "\nInfelizmente sua visita agendada para " + format + ", ao imóvel localizado em "
                + propertyDTO.getRua() + ", " + propertyDTO.getNumero() + ", " + propertyDTO.getCidade() + ", " + propertyDTO.getEstado() + ", " +
                "foi cancelada." +
                "\nEm caso de dúvida, entre em contato pelo telefone 0800-707070." +
                "\n\nSwan Imobiliária");

        return msg;
    }
}
