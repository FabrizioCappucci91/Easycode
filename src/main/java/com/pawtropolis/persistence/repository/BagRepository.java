package com.pawtropolis.persistence.repository;

import com.pawtropolis.persistence.entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BagRepository extends JpaRepository<Bag,Long> {

  @Override
  List<Bag> findAll();
}
