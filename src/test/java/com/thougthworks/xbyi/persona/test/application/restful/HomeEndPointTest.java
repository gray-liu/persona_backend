package com.thougthworks.xbyi.persona.test.application.restful;

import com.thoughtworks.xbyi.persona.Application;
import com.thoughtworks.xbyi.persona.application.restful.HomeEndPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomeEndPoint.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
//@Slf4j2
public class HomeEndPointTest {
    private final static Logger logger = LoggerFactory.getLogger(HomeEndPointTest.class);

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(new HomeEndPoint())
                .defaultRequest(get("/")
                        .contextPath("/v1/api")
                        .accept(MediaType.APPLICATION_JSON)).build();
    }

    @Test
    public void given_home_url_when_hit_get_then_show_home_message() throws Exception {
        logger.info(">>>>> test...");
        mockMvc.perform(get("/v1/api").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name", is("Persona")));
    }
}
