package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "publication")
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 200)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column()
	private Date startingDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column()
	private Date endingDate;

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
