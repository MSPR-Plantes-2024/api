package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "publication")
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Date creationDate = new Date();

	@ManyToOne
	private Address address;

	@ManyToOne
	private User publisher;

	@ManyToOne
	private User gardenKeeper;

	@OneToMany
	private List<Plant> plants;

	@OneToMany
	private List<Comment> comments;

}
