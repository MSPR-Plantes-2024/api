package com.mspprarosaje.arosaje.model;

import com.mspprarosaje.arosaje.model.user.User;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String postalAddress;

	@Column(nullable = false, length = 20)
	private String city;

	@Column(nullable = false)
	private String zipCode;

	@Column
	private String otherInfo;

	@ManyToOne
	private User user;
}
