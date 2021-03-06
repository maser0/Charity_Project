package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.*;

import javax.validation.Valid;

@Controller
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserServiceImpl userService;
    private final EmailService emailService;


    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService, UserServiceImpl userService, EmailService emailService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/form")
    public String donationForm(Model model) {

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String post(@Valid @ModelAttribute Donation donation, @AuthenticationPrincipal CurrentUser customUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        try {
            User user = customUser.getUser();
            donation.setUser(user);
            donationService.save(donation);
            emailService.sendSimpleMessage(user.getUsername(), "Informacje o odbiorze", "Witam \n Miasto "
                    + donation.getCity() + "\n Moment odebrania: " + donation.getPickUpTime() + " " + donation.getPickUpDate() + "\n Ulica: " + donation.getStreet()
                    + "\n Kategorie: " + donation.getCategories() + "\n Worki = " + donation.getQuantity() + " \n Uwagi dla kuriera: " + donation.getPickUpComment()
                    + "\n" + "Dziękujemy ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "formConf";
    }


    @GetMapping("/donation/user")
    public String profile(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        User user = userService.read(entityUser.getId());
        model.addAttribute("user", user);
        return "userDonationList";
    }

    @GetMapping("/donation/{id}")
    public String edit(@PathVariable long id, Model model) {
        Donation donation = donationService.read(id);
        model.addAttribute("Donation", donation);
        return "form";
    }

    @GetMapping("/delete/{id}")

    public String delete(@PathVariable long id) {
        Donation donationToDelete = donationService.read(id);
        donationService.delete(donationToDelete);
        return "redirect:/donation/user";
    }


}
