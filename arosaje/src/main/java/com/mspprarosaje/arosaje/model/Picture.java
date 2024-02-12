package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "picture")
public class Picture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String url;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date creationDate ;

	@PrePersist
	protected void onCreate() {
		creationDate = new Date();
	}
}
