package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.AUTO à utiliser pour une BDD SQLite
	private int id;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	/* Mises en commentaire, car sujet à théories sur de potentielles failles de sécurité
	@Column(nullable = false, length = 10)
	private int phoneNumber;
	*/
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@ManyToOne
	private UserType userType;
}
