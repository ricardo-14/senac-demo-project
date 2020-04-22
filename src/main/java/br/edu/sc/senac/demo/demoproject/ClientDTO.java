package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	
	public static final ClientDTO NULL_VALUE = new ClientDTO(Long.valueOf(0), "", "", "");

	private final Long id;
	private final String name;
	private final String cargo;
	private final String data;

	public ClientDTO(final Long id, final String name, final String cargo, final String data) {
		this.id = id;
		this.name = name;
		this.cargo = cargo;
		this.data = data;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getData() {
		return this.data;
	}

}
