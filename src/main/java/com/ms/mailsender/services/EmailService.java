package com.ms.mailsender.services;

import com.ms.mailsender.enums.StatusEmail;
import com.ms.mailsender.models.EmailModel;
import com.ms.mailsender.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDate(LocalDateTime.now());

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(emailModel.getEmailFrom());
            mailMessage.setTo(emailModel.getEmailTo());
            mailMessage.setSubject(emailModel.getSubject());
            mailMessage.setText(emailModel.getText());
            mailSender.send(mailMessage);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(emailModel);
        }
        return emailModel;
    }
}
