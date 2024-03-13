package com.lalit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	
		 @Autowired
		 private JavaMailSender emailSender;


		public boolean sendMessage(
				  String to, String subject, String body ) {
				    // ...
				      boolean isSent=false;
				      try {
				    MimeMessage message = emailSender.createMimeMessage();
				     
				    
					
				    MimeMessageHelper helper = new MimeMessageHelper(message);
					 
		
					
				    helper.setTo(to);
				    helper.setSubject(subject);
				    helper.setText(body);
				    emailSender.send(message);
				    isSent=true;
					}catch(Exception e) {
						e.printStackTrace();
					}
				      return isSent;
				   

				  
				    // ...
				}
	}


