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
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String text;

	@Column(nullable = false)
	private Date publishingDate = new Date();

	@OneToMany
	private List<Comment> answers;

	@ManyToOne
	private User commentator;

	@ManyToOne
	private Plant plant;
}
