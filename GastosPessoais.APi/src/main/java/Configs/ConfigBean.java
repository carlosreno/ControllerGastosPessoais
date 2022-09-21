package Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigBean {
		
	public WebClient webClient(WebClient.Builder builder) {
		builder
		.baseUrl("http://localhost:8081")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		.build();
		
		
		return null;
		
	}
}
