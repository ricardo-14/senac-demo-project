package br.edu.sc.senac.demo.demoproject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")
final class ClientEntity implements Serializable {

		private static final long serialVersionUID = 4391164751402917205L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)

		private Long clientId;

		private String name;

		private String cargo;

		private String data;

		protected ClientEntity() {
		}

		public ClientEntity(final String name, final String cargo, final String data) {
			this.name = name;
			this.cargo = cargo;
			this.data = data;
		}

		@Override
		public String toString() {
			return "ClientEntity [clientId=" + this.clientId + ", name=" + this.name + ", cargo=" + this.cargo
					+ ", data=" + this.data + "]";
		}

		public Long getClientId() {
			return this.clientId;
		}

		public String getName() {
			return this.name;
		}

		public void setName(final String name) {
			if (name != null) {
				this.name = name;
			}
		}

		public String getCargo() {
			return this.cargo;
		}

		public void setCargo(final String cargo) {
			if (cargo != null) {
				this.cargo = cargo;
			}
		}

		public String getData() {
			return this.data;
		}

		public void setData(final String data) {
			if (data != null) {
				this.data = data;
			}
		}

	}

