package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	private List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return this.clients;
	}

	Long insertClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}

	ResponseEntity <ClientDTO> getClient(Long id) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO client = clients.get(index);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
}
