package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	private final ClientController clientController;

	ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}
	// private List<ClientDTO> clients = new ArrayList<>();

	@PostMapping("/add-default")
	public void addDefault() {
		ClientDTO client = new ClientDTO("Gabriel", "Gerente", "02/09/2003");
		clients.all(client);

		client = new ClientDTO("Macalister", "Colaborador", "21/10/2003");
		clients.add(client);

		client = new ClientDTO("Marcelo", "Colaborador", "21/10/1970");
		clients.add(client);
	}

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return this.clientController.getAllClients();
	}

	@GetMapping("/{id}/details")
	public ClientDTO getClient(@PathVariable Long id) {
		ClientDTO client = this.clientController.getClient(id);
		return client;
		
	}		
		
//		if (id >= clients.size() || id < 0) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		int index = id.intValue();
//		ClientDTO client = clients.get(index);
//		return new ResponseEntity<>(client, HttpStatus.OK);

	@DeleteMapping("/{id}")

	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO client = clients.remove(index);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		return this.clientController.insertClient(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> uptadeClient(@PathVariable Long id, @RequestBody ClientDTO updatedClient) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO oldClient = clients.remove(index);
		clients.add(index, updatedClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
}
