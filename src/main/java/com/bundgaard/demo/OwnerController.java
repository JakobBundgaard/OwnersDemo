package com.bundgaard.demo;

import com.bundgaard.demo.Models.Dog;
import com.bundgaard.demo.Models.Owner;
import com.bundgaard.demo.Repositorys.OwnerRepository;
import com.bundgaard.demo.Service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Controller
public class OwnerController {

    private OwnerService ownerService; // Spring vil selv komme med objektet hertil

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String dogs(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "/Dogs/index";
    }


    @RequestMapping(value = "/owners/addOwner", method = RequestMethod.POST)
    public String addOwners(Owner owner){
        ownerService.save(owner);
        return "redirect:/dogs";
    }
}