package org.softuni.jobboard.service;

import org.softuni.jobboard.model.entity.TechStackEntity;
import org.softuni.jobboard.repository.TechStackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService {

    private TechStackRepository techStackRepository;

    public TechStackService(TechStackRepository techStackRepository) {
        this.techStackRepository = techStackRepository;
    }

    public List<TechStackEntity> allTechStack(){
        return techStackRepository.findAll();
    }
}
