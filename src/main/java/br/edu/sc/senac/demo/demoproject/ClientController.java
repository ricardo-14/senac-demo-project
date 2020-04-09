package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
final class ClientController {

	private List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return this.clients;
	}

	ClientDTO getClient(Long id) {
		if (isExistClient(id)) {
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO client = clients.get(index);
		return client;
	}

	ClientDTO removeClient(Long id) {
		if (isExistClient(id)) {
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO client = clients.remove(index);
		return client;
	}

	Long addClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}

	ClientDTO updateClient(final Long id, ClientDTO updatedClient) {
		if (isExistClient(id)) {
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO oldClient = clients.remove(index);
		clients.add(index, updatedClient);
		return oldClient;
	}

	private boolean isExistClient(final Long id) {

		return id >= clients.size() || id < 0;
	}

}
