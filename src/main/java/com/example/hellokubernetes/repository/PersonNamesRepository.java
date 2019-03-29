package com.example.hellokubernetes.repository;

import com.example.hellokubernetes.model.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNamesRepository extends JpaRepository<PersonName, Long> {
}
