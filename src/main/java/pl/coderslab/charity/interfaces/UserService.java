package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);


}
