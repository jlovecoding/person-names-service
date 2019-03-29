package com.example.hellokubernetes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_names")
@Entity
@Builder
public class PersonName {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String personName;
}
