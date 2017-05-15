/*package com.radiantshub.configurations;

import java.security.Principal;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = "com.radiantshub.controller")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  private static int userCount = 13432;
	
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat").setHandshakeHandler(new UserHandshakeHandler()).withSockJS();
  }
  
  private class UserHandshakeHandler extends DefaultHandshakeHandler{
	  
	  @Override
	  protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String,Object> attributes){
		  String userName = "guest "+userCount++;
		  return new UsernamePasswordAuthenticationToken(userName, null);
	  }
  }
}*/