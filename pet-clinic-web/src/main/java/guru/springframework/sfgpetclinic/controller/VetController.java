package guru.springframework.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listAllVets(Model model){
        final Set<Vet> allVets = vetService.findAll();
        model.addAttribute("vets", allVets);
        return "/vets/index";
    }
}
