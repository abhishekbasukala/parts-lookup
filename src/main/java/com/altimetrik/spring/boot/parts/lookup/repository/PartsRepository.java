package com.altimetrik.spring.boot.parts.lookup.repository;

import com.altimetrik.spring.boot.parts.lookup.model.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends CrudRepository<Part, Long> {
}
