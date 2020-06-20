package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.fixture.InitDataFixture;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final InitDataFixture initDataFixture;


    public HomeController(InstitutionService institutionService, DonationService donationService, InitDataFixture initDataFixture) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.initDataFixture = initDataFixture;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("donations")
    public List <Donation> numberOfDonations() {
        List<Donation> donations = donationService.findAll();

        return donations;
    }

    @ModelAttribute("bags")
    public Integer bags(){
        Integer bags = donationService.sumOfBags();
        return bags;
    }

    @GetMapping ("/initData")
    @ResponseBody
    public String create(){
        this.initDataFixture.initInstitution();
        this.initDataFixture.initCategory();
        return "done";
    }
}




