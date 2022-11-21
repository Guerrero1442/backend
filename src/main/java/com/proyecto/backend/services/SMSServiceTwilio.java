package com.proyecto.backend.services;

import org.springframework.stereotype.Service;

import com.proyecto.backend.model.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSServiceTwilio implements SMSService{
	
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACbe92ccabc62d22e5a2b2c098713606eb";
    public static final String AUTH_TOKEN = "dc2600e1055982f6a73a07ba83a586b6";

    @Override
    public Message sendSMS(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(sms.getPhoneNumberTo()),
                new com.twilio.type.PhoneNumber("+19897689939"),//The Twilio phone number
                sms.getBody())
           .create();

        return message;
    }
}
