package com.gecharita.hexagonal.adapters.secondary.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPersonSQLRepository extends CrudRepository<PersonEntity, Long> {
}
