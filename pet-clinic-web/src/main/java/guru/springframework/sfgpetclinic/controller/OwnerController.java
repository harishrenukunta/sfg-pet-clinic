package guru.springframework.sfgpetclinic.controller;


import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listAllOwners(final Model model){
        model.addAttribute("owners", ownerService.findAll() );
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwner(){
        return "notimplemented";
    }

}
