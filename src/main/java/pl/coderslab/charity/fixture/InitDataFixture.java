package pl.coderslab.charity.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.RoleService;
import pl.coderslab.charity.interfaces.UserService;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitDataFixture {

    private final InstitutionService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitDataFixture(InstitutionService donationService, InstitutionService institutionService,
                           CategoryService categoryService, UserService userService, RoleService roleService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.roleService = roleService;
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


    public void initCategory() {
        Category category = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        Category category4 = new Category();
        category.setName("ubrania, które nadają się do ponownego użycia");
        category2.setName("ubrania, do wyrzucenia");
        category3.setName("zabawki");
        category4.setName("inne");
        categoryService.save(category);
        categoryService.save(category2);
        categoryService.save(category3);
        categoryService.save(category4);
    }

    public void initRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleService.save(roleUser);
    }

    public void initUsers() {

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleService.findOneByName("ROLE_ADMIN"));

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRoles(adminRoles);
        userService.saveUser(admin);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findOneByName("ROLE_USER"));

        User user = new User();
        user.setUsername("user@com.pl");
        user.setPassword("user");
        user.setRoles(userRoles);

        userService.saveUser(user);

        user.getRoles().forEach(e -> System.out.println(e.getName()));
    }
}



