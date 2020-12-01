package com.thoughtworks.xbyi.persona.test.application.restful;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.domain.entity.Demographic;
import com.thoughtworks.xbyi.persona.domain.repository.DemographicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PersonaProfileEndPointTest {
    private final static Logger logger = LoggerFactory.getLogger(PersonaProfileEndPointTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DemographicRepository demographicRepository;


    private Demographic insert(String name) {
        Demographic demographic = new Demographic();
        demographic.setName(name);
        return demographicRepository.save(demographic);
    }

    @Test
    public void get_all_demographics() throws Exception {
        insert("demographic");
        mockMvc.perform(get("/v1/api/demographics").contextPath("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray());
    }
}
