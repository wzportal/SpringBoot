package com.wzportal.app.service;

import javax.mail.MessagingException;
import java.util.Map;

public interface MailService {
    void sendMail(Map<String, Object> data) throws MessagingException;
}
