package com.example.mountains.range.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mountains.range.entity.Range;
import com.example.mountains.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RangeRepository extends JpaRepository<Range, UUID> {
    Optional<Range> findByName(String name);
}
