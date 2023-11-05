package com.example.mountains.range.repository.api;

import com.example.mountains.range.entity.Range;
import com.example.mountains.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RangeRepository extends CrudRepository<Range, UUID> {
    Optional<Range> findByName(String name);
}
