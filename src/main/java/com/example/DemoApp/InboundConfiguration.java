package com.example.DemoApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;

@Configuration
public class InboundConfiguration {


	@Bean
	public IntegrationFlow httpInboundConfigruation(MultipartTransformer multipartTransformer) {
		 return IntegrationFlows.from(Http.inboundGateway("/")
	            .requestMapping(m -> m.methods(HttpMethod.POST, HttpMethod.GET)))
				.transform(multipartTransformer)
				.channel("httpRequest")
				.get();
		
	}
		
	/*will receive parts and return some result*/
	@ServiceActivator(inputChannel="httpRequest")
	public String upCase(Message<String> message) { 
		String input = message.getPayload();
	    if(input!=null && input.length()>0)
	    return input.toUpperCase();
	    else 
	    return "Default Text";
	}

}
