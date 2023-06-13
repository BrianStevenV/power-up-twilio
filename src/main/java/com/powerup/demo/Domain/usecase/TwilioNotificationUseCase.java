package com.powerup.demo.Domain.usecase;

import com.powerup.demo.Domain.api.ITwillioDomainPort;
import com.powerup.demo.Domain.spi.ITwilioServicePort;

import java.util.Random;

public class TwilioNotificationUseCase implements ITwillioDomainPort {
    private final ITwilioServicePort twilioServicePort;
    public TwilioNotificationUseCase(ITwilioServicePort twilioServicePort){
        this.twilioServicePort = twilioServicePort;
    }
    @Override
    public String message() {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong());
        String notification = "The order is ready, the order code is: " + randomNumber + ". Do not share it with anyone.";
        twilioServicePort.message(notification);
        return notification;
    }

}
