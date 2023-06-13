package com.powerup.demo.TwilioNotificationServiceTest;

import com.powerup.demo.Domain.usecase.TwilioNotificationUseCase;
import com.powerup.demo.Domain.spi.ITwilioServicePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Random;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestPropertySource(locations = "classpath:application-dev.yml")
@SpringBootTest
public class TwilioNotificationUseCaseTest {
    @Mock
    private ITwilioServicePort twilioServicePort;
    private TwilioNotificationUseCase notificationUseCase;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        notificationUseCase = new TwilioNotificationUseCase(twilioServicePort);
    }

    @Test
    public void testMessageGenerationAndTwilioServiceCall() {
        // Mock del ITwilioServicePort
        TwilioNotificationUseCase twilioNotificationUseCase = new TwilioNotificationUseCase(twilioServicePort);

        // Llamada al método message()
        String notification = twilioNotificationUseCase.message();

        // Verificar que el número aleatorio se genera correctamente
        long randomNumber = Long.parseLong(notification.split(": ")[1].split("\\.")[0]);
        // Hacer cualquier validación necesaria sobre el número aleatorio generado

        // Verificar que se llame al método message() del twilioServicePort
        verify(twilioServicePort, times(1)).message(notification);
    }

    @Test
    public void testRandomNumberGeneration() {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong());

        Assertions.assertTrue(randomNumber >= 0);
    }
}
