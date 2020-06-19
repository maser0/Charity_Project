package pl.coderslab.charity.fixture;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Service
public class InitDataFixture {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    public InitDataFixture(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    public void initInstitution() {
        Institution institution = new Institution();
        Institution institution2 = new Institution();
        Institution institution3 = new Institution();
        Institution institution4 = new Institution();

        institution.setDescription("Pomoc dzieciom z ubogich rodzin");
        institution2.setDescription("Pomoc osobom znajdującym się w trudnej sytuacji życiowej");
        institution3.setDescription("Pomoc wybudzaniu dzieci ze spiączki");
        institution4.setDescription("Pomoc dla osób bez miejsca zamieszkania");
        institution.setName("Dbam o zdrowie");
        institution2.setName("Dla dzieci");
        institution3.setName("A kogo");
        institution4.setName("Bez domu");
        institutionService.save(institution);
        institutionService.save(institution2);
        institutionService.save(institution3);
        institutionService.save(institution4);
    }

//    public void initDonation(){
//        Donation donation = new Donation();
//        Donation donation1 = new Donation();
//        donation.setCity("Kraków");
//        donation1.setCity("Warszawa");
//        donation.setInstitution();
    }



