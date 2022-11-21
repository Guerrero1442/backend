package com.proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.model.SMS;
import com.proyecto.backend.services.SMSService;
import com.twilio.rest.api.v2010.account.Message;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SMSController {
	@Autowired
	private SMSService smsService;

	@PostMapping("/api/v1/SMS")
	public Message sendSMS(@RequestBody SMS sms) {
		return smsService.sendSMS(sms);
	}
}
