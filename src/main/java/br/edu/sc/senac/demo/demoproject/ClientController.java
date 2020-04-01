package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	List<ClientDTO> getAllClients() {
		 List<ClientDTO> clients = new ArrayList<>();
		
		return clients;
	}
}
