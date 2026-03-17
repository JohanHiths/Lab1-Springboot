package org.example.lab1springboot.contact;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    ContactRepository contactRepository;
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @GetMapping("/contact")
    public String showContactForm(Model model) {

        model.addAttribute("contactForm", new ContactForm("", "", "", "", ""));
        return "contact";
    }

    @PostMapping("/contact/send")
    public String receiveMessage(@Valid @ModelAttribute("contactForm") ContactForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "contact";
        }
        ContactMessage msg = new ContactMessage();
        msg.setFirstName(form.firstName());
        msg.setLastName(form.lastName());
        msg.setEmail(form.email());
        msg.setPhone(form.phone());
        msg.setMessage(form.message());

        contactRepository.save(msg);

        return "redirect:/?success";

    }
    @GetMapping("/contact/")
    public String contact(Model model , @RequestParam(required = false) String submit) {
        model.addAttribute("email", "");
        model.addAttribute("message", "");
        model.addAttribute("name", "");
        model.addAttribute("activePage", "contact");
        model.addAttribute("lastName", "");
        model.addAttribute("phone", "");
        model.addAttribute("submit", submit);
        return "contact";
    }



}
