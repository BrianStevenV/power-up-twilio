package com.powerup.demo.Adapters.driven;

import com.powerup.demo.Configuration.Constants;
import com.powerup.demo.Domain.spi.ITwilioServicePort;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class TwilioAdapter implements ITwilioServicePort {

    @Value("${twilio.account-sid}")
    public String accountSid;
    @Value("${twilio.auth-token}")
    private String authToken;
    @Override
    public void message(String notification) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                        new PhoneNumber(Constants.numberToSend),
                        new PhoneNumber(Constants.numberToTwilio),
                        notification)
                .create();

        System.out.println("  VERIFICATION  TWILIO:  " + message.getSid());
    }
}
