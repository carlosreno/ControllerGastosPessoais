package GastosPessoais.APi_Consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import GastosPessoais.APi_Model.Usuario;
import GastosPessoais.APi_ModelsDTO.EmailDTO;

public class ConsumirServicoEmail {
	@Autowired
	private WebClient webClient;
	
	public EmailDTO SendEmailService(EmailDTO emailDTO) {
		this.webClient.method(HttpMethod.POST)
		.uri("/microserviceemail/envioEmail/sending-email",emailDTO)
		.retrieve();
		
		
		return emailDTO;
	
	}
}
