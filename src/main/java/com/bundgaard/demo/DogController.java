package com.bundgaard.demo;

import com.bundgaard.demo.Models.Dog;
import com.bundgaard.demo.Models.Owner;
import com.bundgaard.demo.Service.DogService;
import com.bundgaard.demo.Service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DogController {

    private DogService dogService;
    private OwnerService ownerService;

    public DogController(DogService dogService, OwnerService ownerService) {
        this.dogService = dogService;
        this.ownerService = ownerService;
    }

    @GetMapping("/dogs")
    public String dogs(Model model){
        model.addAttribute("dogs", dogService.findAll());
        model.addAttribute("owners", ownerService.findAll());
        return "/Dogs/index";
    }

    @RequestMapping(value = "/dogs/addDog", method = RequestMethod.POST)
    public String addDog(Dog dog, @RequestParam("owner") String ownerId){
        Optional<Owner> owner = ownerService.findById(Long.parseLong(ownerId));
        if(owner.isPresent()){
            dog.setOwner(owner.get());
            owner.get().getDogs().add(dog);
        }
        dogService.save(dog);
        return "redirect:/dogs";
    }
}