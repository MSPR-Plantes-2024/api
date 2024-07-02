package com.mspprarosaje.arosaje.model;

import com.mspprarosaje.arosaje.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String text;

	@Column(nullable = false)
	private LocalDateTime publishingDate = LocalDateTime.now();

	@ManyToOne
	private User commentator;

	@ManyToOne
	private Report report;
}
