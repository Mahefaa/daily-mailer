package com.mailer.daily.endpoint.rest.controller;

import com.mailer.daily.mail.Email;
import com.mailer.daily.mail.Mailer;
import com.mailer.daily.model.EmailRequest;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {
  private final Mailer mailer;

  @GetMapping
  public String emailForm(Model model) {
    model.addAttribute("emailRequest", new EmailRequest());
    return "email";
  }

  @PostMapping
  public String sendEmail(@ModelAttribute EmailRequest emailRequest, Model model)
      throws AddressException {
    Email email =
        new Email(
            new InternetAddress(emailRequest.getTo()),
            List.of(),
            List.of(),
            emailRequest.getSubject(),
            emailRequest.getBody(),
            List.of());
    try {
      mailer.accept(email);
      model.addAttribute("message", "Email sent successfully!");
    } catch (Exception e) {
      model.addAttribute("message", "Error sending email: " + e.getMessage());
    }
    return "email";
  }
}
