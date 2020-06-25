package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;


@Controller
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/view")   // tutaj wylaczam admin zeby narazie pracowac dalej
      public String adm(){
      return "adminView";
  }

  @GetMapping("/institution/list")  // tutaj wylaczam admin zeby narazie pracowac dalej
    public String inst(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "institutionList";

  }

    @GetMapping("/institution/{id}")
    public String edit(@PathVariable long id, Model model){
        Institution institution = institutionService.read(id);
        model.addAttribute("institution", institution);
        return "institutionCreate";
    }


    @PostMapping ("/institution/post")
    public String post (@Valid @ModelAttribute Institution institution, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "institutionCreate";
        }
        try {
            institutionService.save(institution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/institution/list";
    }

    @GetMapping ("institution/create")
    public String create(Model model){
        model.addAttribute("institution", new Institution());
        return "institutionCreate";
    }

    @GetMapping("institution/delete/{id}")

    public String delete(@PathVariable long id) {
        Institution institutionToDelete = institutionService.read(id);
        institutionService.delete(institutionToDelete);
        return "redirect:/institution/list";
    }


}
