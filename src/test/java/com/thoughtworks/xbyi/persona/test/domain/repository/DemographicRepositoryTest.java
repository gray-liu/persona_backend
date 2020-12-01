package com.thoughtworks.xbyi.persona.test.domain.repository;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import com.thoughtworks.xbyi.persona.domain.repository.DemographicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
public class DemographicRepositoryTest {
    private final static Logger logger = LoggerFactory.getLogger(DemographicRepositoryTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DemographicRepository demographicRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(demographicRepository).isNotNull();
    }

    private Demographic insert(String name) {
        Demographic demographic = new Demographic();
        demographic.setName(name);
        return  demographicRepository.save(demographic);
    }

    @Test
    public void find_all_data() {
        Demographic demographic = insert("mike");
        assert demographic.getId() != null;
        logger.debug(demographic.toString());
        List<Demographic> results = demographicRepository.findAll();
        assertThat(results.size() > 0);
    }
}
