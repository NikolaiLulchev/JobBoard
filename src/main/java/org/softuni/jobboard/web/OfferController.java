package org.softuni.jobboard.web;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.dto.OfferAddDTO;
import org.softuni.jobboard.model.entity.OfferEntity;
import org.softuni.jobboard.model.view.OfferViewModel;
import org.softuni.jobboard.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public String offers(Model model) {
        model.addAttribute("offers", offerService.
                getAllOffers());
        return "offers";
    }

    @GetMapping("/details/{id}")
    @Transactional
    public String offerDetails(@PathVariable Long id, Model model) {
        OfferEntity offer = offerService.getOfferById(id);
        OfferViewModel offerViewModel = modelMapper.map(offer, OfferViewModel.class);
        model.addAttribute("offerViewModel", offerViewModel);
        return "offer-details";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        OfferAddDTO offerAddDTO = new OfferAddDTO();
        offerAddDTO.setCompanyName("");
        model.addAttribute("offerModel", offerAddDTO);
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
    private OfferAddDTO offerModel() {
        return new OfferAddDTO();
    }
}

