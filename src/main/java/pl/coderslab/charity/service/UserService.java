package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save (User user){
        userRepository.save(user);
    }

    public void delete (User user){
        userRepository.delete(user);
    }

    public void edit (User user){
        User userToEdit = userRepository.getOne(user.getId());
        userRepository.save(userToEdit);
    }
    public User read (Long id){
        return  userRepository.getOne(id);

    }

    public List<User> findAll (){
        return  userRepository.findAll();
    }
}
