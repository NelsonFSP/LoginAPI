package com.nfspdev.loginAPI.tests;

import com.nelson.LoginAPI.userDTO.UserDTO;
import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.entrypoint.controller.CreateUserController;
import com.nfspdev.loginAPI.tests.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@RestClientTest(CreateUserController.class)
public class CreateUserControllerTest {

    @Autowired
    private CreateUserController controller;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void testCreateUser() throws Exception {
        // Dados de entrada
        User user = new User(
                UUID.randomUUID().toString(),
                "John Doe",
                "123456",
                "123456");

        UserDTO userDTO = user

        // Configuração do mock
        Mockito.when(databaseServiceImpl.insert(any(User.class))).thenReturn(user);

        // Execução do teste
        this.server.expect(request -> {
            request.execute(controller.insert(user));
        } )
        // Execução do teste
        mockMvc.perform(MockMvcRequestBuilders.post("/create/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJsonBytes(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(user.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value(user.getLogin()));
    }
}
