package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;


    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("numberOfDonations")
    public Integer numberOfDonations() {
        Integer count = 0;
        List<Donation> donationList = donationService.findAll();
        for (int i = 0; i < donationList.size(); i++) {
            count++;
        }
        return count;
    }

    @ModelAttribute("numberOfInstitutions")
    public Integer numberOfInstitutions(){
        Integer count = 0;
        List <Institution> institutions = institutionService.findAll();
        for (int i = 0; i <institutions.size() ; i++) {
            count++;

        }
        return count;
    }
}




