package com.mspprarosaje.arosaje.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private String description;

	@OneToOne
	private Picture picture;

	@Column(nullable = false)
	private String user;

	@ManyToOne
	private PlantCondition plantCondition;

}
