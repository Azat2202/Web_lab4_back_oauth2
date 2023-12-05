package ru.web_lab4.authController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Base64;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void whenRegisterValidInput_thenReturns200() throws Exception{
        this.mockMvc.perform(
                        post("/api/register")
                                .param("login", "1")
                                .param("password", "1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void whenLoginValidInput_thenReturns200() throws Exception {
        this.mockMvc.perform(
                post("/api/login")
                        .header("Authorization", "Basic " +
                                new String(Base64.getEncoder().encode("1:1".getBytes())))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
