package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public void save (Institution institution){
        institutionRepository.save(institution);
    }

    public void delete (Institution institution){
        institutionRepository.delete(institution);
    }

    public void edit (Institution institution){
        Institution institutionToEdit = institutionRepository.getOne(institution.getId());
        institutionRepository.save(institutionToEdit);
    }
    public Institution read (Long id){
        return  institutionRepository.getOne(id);

    }

    public List<Institution> findAll (){
        return  institutionRepository.findAll();
    }
    
}
