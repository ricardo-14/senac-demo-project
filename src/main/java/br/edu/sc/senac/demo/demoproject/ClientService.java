package br.edu.sc.senac.demo.demoproject;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	private final ClientController clientController;

	ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}

	@PostMapping("/add-default")
//	public void addDefault() {
//		addClient("Marcelo", "Gerente", "21/10/1970");
//		addClient("Gabriel", "Colaborador", "02/09/2003");
//		addClient("Macalister", "Colaborador", "21/10/2003");
//	}

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return this.clientController.getAllClients();
	}

	@GetMapping("/{id}/details")
	public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
		ClientDTO client = this.clientController.getClient(id);
		if (ClientDTO.NULL_VALUE.equals(client)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id) {
		ClientDTO removedClient = this.clientController.removeClient(id);
		if (ClientDTO.NULL_VALUE.equals(removedClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedClient, HttpStatus.OK);
	}
//
//	@PostMapping("/add")
//	public Long addClient(@RequestParam("nome") String nome, @RequestParam("cargo") String cargo,
//			@RequestParam("data") String data) {
//		ClientDTO client = new ClientDTO(nome, cargo, data);
//		return this.clientController.addClient(client);
//	}
//	@PostMapping("/addpayload")
//	public Long addClient(@RequestBody ClientDTO client) {
//		return this.clientController.addClient(client);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> uptadeClient(@PathVariable Long id, @RequestBody ClientDTO updatedClient) {
		ClientDTO oldClient = this.clientController.updateClient(id, updatedClient);
		if (ClientDTO.NULL_VALUE.equals(oldClient)) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
}
