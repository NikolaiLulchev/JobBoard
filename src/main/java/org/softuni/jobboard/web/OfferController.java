package org.softuni.jobboard.web;

import org.softuni.jobboard.model.dto.OfferAddDTO;
import org.softuni.jobboard.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("")
    public String offers(Model model) {
        model.addAttribute("offers", offerService.
                getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer() {
        return "add-offer";
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferAddDTO offerModel, Principal principal,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/add";
        }
        this.offerService.postOffer(principal, offerModel);

        return "redirect:/offers";
    }

    @ModelAttribute("offerModel")
    private OfferAddDTO offerModel(){return new OfferAddDTO();}
}

