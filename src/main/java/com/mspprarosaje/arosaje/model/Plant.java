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
@Table(name = "plant")
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private String description;

	@OneToOne
	private Picture picture;

	@ManyToOne
	private User user;

	@ManyToOne
	private PlantCondition plantCondition;

	@ManyToOne
	private Address address;

}
