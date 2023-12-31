package com.ibragimov.apptaskmanagement.service;

import com.ibragimov.apptaskmanagement.api.response.ApiResponse;
import com.ibragimov.apptaskmanagement.service.template.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public ApiResponse sendEmail(String to, String code) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("no-reply@ibragimovdemo.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("Akkauntni tasdiqlash");
            mailMessage.setText("<a href='http:/localhost:8080/api/auth/verify?emailCode=" + code + "&email=" + to + "'>Tasqidlash</a>");

            javaMailSender.send(mailMessage);
            return new ApiResponse("Successfully sent",true);
        }catch (Exception e){
            return new ApiResponse(e.getMessage(),false);
        }
    }
}
