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
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition="TEXT")
    private String text;

    @Column(nullable = false)
    private Date publishingDate = new Date();

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;
}
