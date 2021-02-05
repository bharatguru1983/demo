package com.example.DemoApp;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class MultipartTransformer {
	
	public String transform(Message message) { 
		 MultiValueMap<String, String> 	payload = (LinkedMultiValueMap<String, String>) message.getPayload(); 
		 //Code to parse the multipart data goes here but payload map received empty all the time
	 	return	"Unable to Process MultiPart"; 
	 }

}
