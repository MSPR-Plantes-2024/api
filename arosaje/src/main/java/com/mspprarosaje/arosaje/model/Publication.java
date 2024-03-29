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

	@Column(length = 200)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date creationDate;

	@ManyToOne
	private Address address;

	@ManyToOne
	private User publisher;

	@ManyToOne
	private User gardenKeeper;

	@ManyToMany
	private List<Plant> plants;

	@OneToMany
	private List<Report> reports;

	@PrePersist
	protected void onCreate() {
		creationDate = new Date();
	}
}
