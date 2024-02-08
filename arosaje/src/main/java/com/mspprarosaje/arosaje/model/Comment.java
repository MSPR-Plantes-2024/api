package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	@Column(nullable = false, columnDefinition = "TEXT")
	private String text;

	@Column(nullable = false)
	private LocalDateTime publishingDate = LocalDateTime.now();

	@ManyToOne
	private Comment comment;

	@OneToMany(mappedBy = "comment")
	private List<Comment> answers = new ArrayList<>();

	@ManyToOne
	private User commentator;

	@ManyToOne
	private Plant plant;
}
