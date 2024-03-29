package com.mspprarosaje.arosaje.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, columnDefinition="TEXT")
    private String text;

    @Column(nullable = false)
    private LocalDateTime publishingDate = LocalDateTime.now();

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;
}
