package com.thoughtworks.xbyi.persona.domain.repository;

import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, Long> {
}
