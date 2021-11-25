package platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CodeSharingPlatformProjectApplicationTests {
    @Autowired
    private Controller controller;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    UUID id = UUID.fromString("7188bd70-c0e4-4370-b9d7-3a7cab6f7c81");
    String code = "print('Hello, world!')";

    @Test
    public void assertContext() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnGreeting() throws Exception {
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello!")));
    }

    @Test
    public void postCode() throws Exception {
        Map<String, String> map = Map.of("code", code);
        MvcResult result = this.mockMvc.perform(post("/api/code/new").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(map)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        id = UUID.fromString(JsonPath.read(result.getResponse().getContentAsString(), "$.id"));

    }

    @Test
    public void getCode() throws Exception {
        this.mockMvc.perform(get("/api/code/" + id)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(code)));

    }
}
