package guru.springframework.sfgpetclinic.controller;


import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listAllOwners(final Model model){
        model.addAttribute("owners", ownerService.findAll() );
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwner(){
        return "notimplemented";
    }

    @GetMapping("/{id}")
    public ModelAndView getOwnerDetails(@PathVariable String id){
        final Owner owner = ownerService.findById(Long.valueOf(id));
        final ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        mav.addObject(owner);
        return mav;
    }

}
