package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void save (Donation donation){
        donationRepository.save(donation);
    }

    public void delete (Donation donation){
        donationRepository.delete(donation);
    }

    public void edit (Donation donation){
        Donation donationToEdit = donationRepository.getOne(donation.getId());
        donationRepository.save(donationToEdit);
    }
    public Donation read (Long id){
        return  donationRepository.getOne(id);

    }

    public List<Donation> findAll (){
        return  donationRepository.findAll();
    }
}
