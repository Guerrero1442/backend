package com.proyecto.backend.services;

import com.proyecto.backend.model.SMS;
import com.twilio.rest.api.v2010.account.Message;

public interface SMSService {
	public Message sendSMS(SMS sms);
}
