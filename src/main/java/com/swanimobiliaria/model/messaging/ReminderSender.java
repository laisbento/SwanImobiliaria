package com.swanimobiliaria.model.messaging;

import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ReminderSender {

    private JavaMailSender javaMailSender;

    @Autowired
    private ReminderSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public ReminderSender() {
    }

    public void sendEmail(VisitDTO visitDTO, PropertyDTO propertyDTO) {
        SimpleMailMessage msg = buildEmail(visitDTO, propertyDTO);

        javaMailSender.send(msg);
    }

    private SimpleMailMessage buildEmail(VisitDTO visitDTO, PropertyDTO propertyDTO) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        String format = simpleDateFormat.format(visitDTO.getVisitDate());

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
}
