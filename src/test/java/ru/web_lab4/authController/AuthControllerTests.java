package ru.web_lab4.authController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Mock
    private UserRepository userMockRepository;

    @Test
    void whenRegisterValidInput_thenReturns200() throws Exception{
        Mockito.when(userMockRepository.findByLogin("1")).thenReturn(null);

        this.mockMvc.perform(
                        post("/api/register")
                                .param("login", "1")
                                .param("password", "1")
                )
                .andDo(print())
                .andExpect(status().isOk());

        Mockito.verify(userMockRepository).findByLogin("1");
    }

    @Test
    void whenLoginValidInput_thenReturns200() throws Exception {
        UserRepository userMockRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userMockRepository.findByLogin("1")).thenReturn(new ApplicationUser("1", "1", ""));

        this.mockMvc.perform(
                post("/api/login")
                        .header("Authorization", "Basic " +
                                new String(Base64.getEncoder().encode("1:1".getBytes())))
                )
                .andDo(print())
                .andExpect(status().isOk());

        Mockito.verify(userMockRepository).findByLogin("1");
    }
}
