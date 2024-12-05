package nttdata.api.clients;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import nttdata.api.clients.controller.ClienteController;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void clienteEncontrado() throws Exception {
        mockMvc.perform(get("/api/clientes/C/23445322"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primerNombre").value("Juan"));
    }

    @Test
    void clienteNoEncontrado() throws Exception {
        mockMvc.perform(get("/api/clientes/C/99999999"))
                .andExpect(status().isNotFound());
    }    
}
