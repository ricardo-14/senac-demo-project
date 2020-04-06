package br.edu.sc.senac.demo.demoproject;

public class ContaDTO {
	public static final ContaDTO NULL_VALUE = new ContaDTO("", "", "");

	private final String name;
	private final String cargo;
	private final String data;
	
	public ContaDTO(final String name, final String cargo, final String data) {
		this.name = name;
		this.cargo = cargo;
		this.data = data;
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

