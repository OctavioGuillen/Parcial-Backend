package com.example.parcial_backend.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import java.io.Serializable;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
}
