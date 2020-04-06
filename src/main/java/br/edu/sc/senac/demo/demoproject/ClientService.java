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
		ContaDTO client = new ContaDTO("Gabriel", "Gerente", "02/09/2003");
		clients.all(client);

		client = new ContaDTO("Macalister", "Colaborador", "21/10/2003");
		clients.add(client);

		client = new ContaDTO("Marcelo", "Colaborador", "21/10/1970");
		clients.add(client);
	}

	@GetMapping("/list")
	public List<ContaDTO> list() {
		return this.clientController.getAllClients();
	}

	@GetMapping("/{id}/details")
	public ResponseEntity<ContaDTO> getClient(@PathVariable Long id) {
		ResponseEntity<ContaDTO> client = this.clientController.getClient(id);
		return client;
	}

//		if (id >= clients.size() || id < 0) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		int index = id.intValue();
//		ClientDTO client = clients.get(index);
//		return new ResponseEntity<>(client, HttpStatus.OK);

	@DeleteMapping("/{id}")

	public ResponseEntity<ContaDTO> removeClient(@PathVariable Long id) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ContaDTO client = clients.remove(index);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ContaDTO client) {
		return this.clientController.insertClient(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContaDTO> uptadeClient(@PathVariable Long id, @RequestBody ContaDTO updatedClient) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ContaDTO oldClient = clients.remove(index);
		clients.add(index, updatedClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
}
