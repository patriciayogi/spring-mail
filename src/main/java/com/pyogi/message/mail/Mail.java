package com.pyogi.message.mail;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class Mail {

    @NotBlank(message = "email is mandatory")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String to;
    @NotBlank(message = "subject is mandatory")
    private String subject;
    @NotBlank(message = "message is mandatory")
    private String message;
}
