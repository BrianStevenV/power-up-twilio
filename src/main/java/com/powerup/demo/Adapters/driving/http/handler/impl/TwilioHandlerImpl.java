package com.powerup.demo.Adapters.driving.http.handler.impl;

import com.powerup.demo.Adapters.driving.http.handler.ITwilioHandler;
import com.powerup.demo.Domain.api.ITwillioDomainPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioHandlerImpl implements ITwilioHandler {
    private final ITwillioDomainPort twillioServicePort;
    @Override
    public String message() {
        return twillioServicePort.message();
    }
}
