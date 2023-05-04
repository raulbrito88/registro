package com.ps.registro.servicios;

import com.ps.registro.modelo.Persona;
import com.ps.registro.repository.PersonaRepository;
import com.ps.registro.services.PersonaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class PersonaServiceImplTest {

    @InjectMocks
    PersonaService personaService;

    @Mock
    PersonaRepository personaRepository;

    @BeforeEach
    public void init() {
        MockitoJunit5.openMocks(this);
    }

    @Test
    @Rollback
    public void testGuardarPersonaExitoso() throws Exception {
        Persona personaMock = new Persona();
        personaMock.setId(1L);
        personaMock.setCorreo("example@example.com");
        personaMock.setIdentificacion("123456789");
        when(personaRepository.save(any(Persona.class))).thenReturn(personaMock);

        Persona personaGuardada = personaService.guardar(personaMock);

        Assertions.assertEquals(personaMock, personaGuardada);
    }

    @Test
    @Rollback
    public void testGuardarPersonaConNumeroNegativo() {
        Persona personaMock = new Persona();
        personaMock.setId(-1L);

        Assertions.assertThrows(Exception.class, () -> {
            personaService.guardar(personaMock);
        });
    }
}
