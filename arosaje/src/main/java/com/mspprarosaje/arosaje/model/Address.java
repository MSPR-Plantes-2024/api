package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String postalAddress;

	@Column(nullable = false, length = 20)
	private String city;

	@Column(nullable = false)
	private int zipCode;

	@Column(nullable = false)
	private String otherInfo;

	@ManyToOne
	private User user;
}
