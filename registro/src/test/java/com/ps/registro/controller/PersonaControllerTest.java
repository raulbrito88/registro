package com.ps.registro.controller;

import com.ps.registro.modelo.Persona;
import com.ps.registro.services.IPersonaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.when;

@WebMvcTest(PersonaController.class)
public class PersonaControllerTest {

    @MockBean
    private IPersonaService personaService;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testConsultarPersonaExistente() throws Exception {
        Long personaId = 1L;
        Persona persona = new Persona();
        persona.setId(personaId);
        when(personaService.consultar(personaId)).thenReturn(persona);

        mockMvc.perform(MockMvcRequestBuilders.get("/persona/{id}", personaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(personaId))
                .andDo(MockMvcResultHandlers.print());
    }
/*
    @Test
    public void testConsultarPersonaNoExistente() throws Exception {
        Long personaId = 1L;
        when(personaService.consultar(personaId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/persona/{id}", personaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
*/


}