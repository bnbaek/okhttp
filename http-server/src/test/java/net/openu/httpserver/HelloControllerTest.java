package net.openu.httpserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by iopenu@gmail.com on 2020/02/18
 * Github : https://github.com/bnbaek
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {HelloController.class})
//@SpringBootTest @AutoConfigureMockMvc
public class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void hellos() throws Exception {
    this.mockMvc.perform(get("/api/hellos")
            .contentType(MediaType.APPLICATION_JSON)
//        .content(objectMapper.writeValueAsString(event))
    )

        .andDo(print())
        .andExpect(status().isOk())
    ;
  }
}

