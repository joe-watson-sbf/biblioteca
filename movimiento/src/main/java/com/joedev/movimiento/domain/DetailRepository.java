package com.joedev.movimiento.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends CrudRepository<LoanedDetail, Integer> {
}
