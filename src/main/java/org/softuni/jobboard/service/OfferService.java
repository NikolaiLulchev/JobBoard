package org.softuni.jobboard.service;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.dto.OfferAddDTO;
import org.softuni.jobboard.model.entity.OfferEntity;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.view.OfferViewModel;
import org.softuni.jobboard.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final UserService userService;

    public OfferService(ModelMapper modelMapper, OfferRepository offerRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.userService = userService;
    }

    public void postOffer(Principal principal, OfferAddDTO offerModel) {

        UserEntity user = userService.getUser(principal.getName());

        OfferEntity offer = modelMapper.map(offerModel, OfferEntity.class);
        offer.setTechStack(userService.getTechStackEntityList(offerModel.getTechStack()));
        offer.setUser(user);
        offer.setAddedOn(LocalDateTime.now());
        offer.getCompany().setUsers(Set.of(user));
        offerRepository.save(offer);
    }

    public List<OfferViewModel> getAllOffers() {
        return offerRepository.findAllByOrderByAddedOnDesc().stream()
                .map(offerEntity -> modelMapper.map(offerEntity, OfferViewModel.class)).collect(Collectors.toList());
    }

    public OfferEntity getOfferById(Long id) {
        return offerRepository.getById(id);
    }

    public void proceedOfferTask() {
        LocalDateTime addedOn = LocalDateTime.now().minusDays(14);
        offerRepository.findByAddedOnBefore(addedOn).
                forEach((o-> o.setActive(false)));
    }
}
