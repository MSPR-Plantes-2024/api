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
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String text;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date publishingDate = new Date();

	@ManyToOne
	private Publication publication;

	@OneToMany
	private List<Picture> pictures;

	@PrePersist
	protected void onCreate() {
		publishingDate = new Date();
	}

}
