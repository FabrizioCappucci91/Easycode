package com.pawtropolis.persistence.repository;

import com.pawtropolis.persistence.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

  @Override
  List<Animal> findAll();
}
