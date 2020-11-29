package com.thoughtworks.xbyi.persona.domain.repository;

import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import org.springframework.data.repository.CrudRepository;


public interface DemographicRepository extends CrudRepository<Demographic, Long> {
}
