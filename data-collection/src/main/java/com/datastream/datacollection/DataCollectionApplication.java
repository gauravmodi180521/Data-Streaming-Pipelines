package com.datastream.datacollection;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class DataCollectionApplication {
	
	private static final String rsvpEndPoint = "ws://stream.meetup.com/2/rsvps";
	public static void main(String[] args) {
		SpringApplication.run(DataCollectionApplication.class, args);
	}
	
	@Bean
    public ApplicationRunner initializeConnection(
        RsvpWebSocketHandler rsvpsWebSocketHandler) {
           return args -> {
               WebSocketClient rsvpsSocketClient = new StandardWebSocketClient();

               rsvpsSocketClient.doHandshake(
                   rsvpsWebSocketHandler, rsvpEndPoint);           
           };
       }
}
