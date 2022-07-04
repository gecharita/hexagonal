package com.gecharita.hexagonal.infrastructure.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPersonSQLRepository extends CrudRepository<PersonEntity, Long> {
}
