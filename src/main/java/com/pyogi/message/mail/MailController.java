package com.pyogi.message.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public ResponseEntity send(@RequestParam String to, @RequestParam String subject, @RequestParam String message) {
        mailService.sendEmail(to, subject, message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
