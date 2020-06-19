package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;

import java.util.Optional;


public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM (quantity) FROM Donation ")
    Integer sumOfBags();

}
