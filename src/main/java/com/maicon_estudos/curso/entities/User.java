package com.maicon_estudos.curso.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
// Declaração da classe pública "User". Esta classe será usada para representar os dados de um usuário.
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	// Atributo privado "id" do tipo Long, que provavelmente será o identificador único do usuário no banco de dados.
	
	private String name; 
	private String email; 
	private String phone; 	
	private String password; 
	
	@JsonIgnore
	@OneToMany(mappedBy ="client")
	private List<Order> orders = new ArrayList<>();

	public User() {
		// Construtor padrão (sem parâmetros), usado quando não se quer inicializar a classe com valores iniciais.
	}

	public User(Long id, String name, String email, String phone, String password) {
		super(); 
		// Chama o construtor da classe pai (neste caso, Object). 
		// No entanto, como User não está herdando nenhuma outra classe específica, não haveria necessidade explícita de chamar super().
		
		this.id = id;
		// Inicializa o atributo "id" com o valor passado como parâmetro.
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
