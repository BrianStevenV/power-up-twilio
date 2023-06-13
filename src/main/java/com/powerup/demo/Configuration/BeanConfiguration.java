package com.powerup.demo.Configuration;

import com.powerup.demo.Adapters.driven.TwilioAdapter;
import com.powerup.demo.Domain.usecase.TwilioNotificationUseCase;
import com.powerup.demo.Domain.api.ITwillioDomainPort;
import com.powerup.demo.Domain.spi.ITwilioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public ITwilioServicePort twilioServicePort(){
        return new TwilioAdapter();
    }
    @Bean
    public ITwillioDomainPort twilioDomainPort(){
        return new TwilioNotificationUseCase(twilioServicePort());
    }
}
