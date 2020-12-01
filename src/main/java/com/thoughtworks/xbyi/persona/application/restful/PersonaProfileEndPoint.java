package com.thoughtworks.xbyi.persona.application.restful;

import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import com.thoughtworks.xbyi.persona.domain.repository.DemographicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaProfileEndPoint {
    @Autowired
    private DemographicRepository demographicRepository;

    @GetMapping("/demographics")
    List<Demographic> getDemographics() {
        return demographicRepository.findAll();
    }
}
